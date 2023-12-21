package com.yhan219.janetfilter.plugin.rainbowbrackets;

import com.janetfilter.core.plugin.MyTransformer;
import javassist.ClassPool;
import javassist.CtClass;

import java.io.ByteArrayInputStream;
import java.security.ProtectionDomain;

public class RequestFastTransformer implements MyTransformer {


    @Override
    public String getHookClassName() {
        return "io/github/kings1990/plugin/fastrequest/cofig/l1II1l1Il1lI1l111l1I";
    }


    @Override
    public byte[] transform(ClassLoader loader, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, String className, byte[] classBytes, int order) throws Exception {
        final ClassPool pool = ClassPool.getDefault();
        pool.appendSystemPath();
        final CtClass clazz = pool.makeClass(new ByteArrayInputStream(classBytes));

        clazz.getDeclaredMethod("IllIlIl11I1l1lI11").insertBefore("if(true) return true;");

        classBytes = clazz.toBytecode();
        clazz.detach();

        return classBytes;
    }


}
