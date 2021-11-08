package com.lorne.jni.utils;

import java.io.IOException;
import java.lang.reflect.Field;

/**
 * 通过反射实现动态添加java.library.path 库
 * 由于usr_paths的数据加载，是在JVM阶段获取的，无法在程序阶段实现配置
 * https://blog.csdn.net/cruise_h/article/details/41575481
 * @author lorne
 * @since 1.0.0
 */
public class LibraryUtils {


    public static void addLibraryDir(String libraryPath) throws IOException {
        try {
            Field field = ClassLoader.class.getDeclaredField("usr_paths");
            field.setAccessible(true);
            String[] paths = (String[]) field.get(null);
            for (int i = 0; i < paths.length; i++) {
                if (libraryPath.equals(paths[i])) {
                    return;
                }
            }
            String[] tmp = new String[paths.length + 1];
            System.arraycopy(paths, 0, tmp, 0, paths.length);
            tmp[paths.length] = libraryPath;
            field.set(null, tmp);
        } catch (IllegalAccessException e) {
            throw new IOException(
                    "failed to get permissions to set library path");
        } catch (NoSuchFieldException e) {
            throw new IOException(
                    "failed to get field handle to set library path");
        }
    }

}
