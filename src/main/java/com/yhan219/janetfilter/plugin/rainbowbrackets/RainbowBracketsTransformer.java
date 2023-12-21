package com.yhan219.janetfilter.plugin.rainbowbrackets;

import com.janetfilter.core.plugin.MyTransformer;
import javassist.ClassPool;
import javassist.CtClass;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.security.ProtectionDomain;
import java.util.Arrays;

public class RainbowBracketsTransformer implements MyTransformer {


    @Override
    public String getHookClassName() {
        return new String(new byte[]{-32, -72, -107, -31, -72, -85}, StandardCharsets.UTF_8);
    }


    @Override
    public byte[] transform(ClassLoader loader, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, String className, byte[] classBytes, int order) throws Exception {
        final ClassPool pool = ClassPool.getDefault();
        pool.appendSystemPath();
        final CtClass clazz = pool.makeClass(new ByteArrayInputStream(classBytes));
        Arrays.stream(clazz.getDeclaredMethods(new String(new byte[]{-31, -68, -116, -31, -68, -100}, StandardCharsets.UTF_8))).forEach(method -> {
            try {
                method.insertBefore("if(true) return false;");
            } catch (Exception e) {
                System.out.println("crack RainbowBrackets error --------------" + method.getName());
            }
        });

        clazz.getDeclaredMethod(new String(new byte[]{-32, -80, -123, -32, -78, -101}, StandardCharsets.UTF_8)).insertBefore("if(true)return false;");

        clazz.getDeclaredMethod(new String(new byte[]{-32, -78, -73, -47, -71}, StandardCharsets.UTF_8)).insertBefore("if(true) return false;");

        classBytes = clazz.toBytecode();
        clazz.detach();

        return classBytes;
    }


}
