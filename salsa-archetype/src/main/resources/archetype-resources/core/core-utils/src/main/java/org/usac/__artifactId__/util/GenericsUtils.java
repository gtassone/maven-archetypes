package org.usac.${artifactId}.util;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class GenericsUtils {

    /**
     * Returns the actual class of the parameter type in a generic (Parameterized) class or its subclasses.
     * Example:
     *  <code>
     *      Given:
     *              public abstract class AbstractExample<AW extends AbstractWhatever> {
     *              }
     *
     *              public abstract class AbstractWhatever {
     *              }
     *
     *              public class Whatever extends AbstractWhatever {
     *              }
     *
     *              public class WhateverExample extends AbstractExample<Whatever> {
     *              }
     *      Result:
     *          Calling GenericUtils.getParameterClass(WhateverExample.class, AbstractWhatever.class)
     *          returns Whatever.class
     *  </code>
     *
     * @param objectClass The class to search
     * @param <T> The type of class to return
     * @return The class of the parameter type requested
     */
    @SuppressWarnings("unchecked")
    public static <T> Class<T> getParameterClass(Class<?> objectClass, Class<? super T> parameterClass) {
        while (objectClass != null) {
            Type classType = objectClass.getGenericSuperclass();
            if ((classType != null) && (classType instanceof ParameterizedType)) {
                for (Type parameterType : ((ParameterizedType) classType).getActualTypeArguments()) {
                    try {
                        Class parameterTypeClass = (Class)parameterType;
                        if (parameterClass.isAssignableFrom(parameterTypeClass)) {
                            return (Class<T>)parameterTypeClass;
                        }
                    }
                    catch(Exception e) {
                        // Ignore. Some arguments may not be cast to Class
                    }


                }
            }
            objectClass = objectClass.getSuperclass();
        }
        return null;
    }
}
