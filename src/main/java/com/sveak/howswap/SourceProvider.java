package com.sveak.howswap;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class SourceProvider {

    public static final String JAVA_EXT = ".java";
    private String rootDir;

    public SourceProvider(final String rootDir) {
        this.rootDir = rootDir;
    }

    public String getSourceString(final String name) throws IOException {
        final File srcFile = getSourceFile(name);
        if (!srcFile.exists()) {
            throw new FileNotFoundException("Java source for " + name + " not found");
        }
        return FileUtils.readFileToString(srcFile);
    }

    public File getSourceFile(String name) {
        final String path = name.replace(".", "/");
        final File srcFile = new File(rootDir, path + JAVA_EXT);
        return srcFile;
    }

    public boolean sourceExistsInFileSystem(final String className) {
        final String path = className.replace('.', '/');
        final File file = new File(rootDir, path + JAVA_EXT);
        return file.exists();
    }

    public boolean directoryExistsInFileSystem(final String packageName) {
        String path = packageName.replace('.', '/');
        File dir = new File(rootDir, path);
        return dir.exists();
    }

    public List<String> getAllClassesFromPackage(final String packageName) {
        final String path = packageName.replace(".", "/");
        final File srcDir = new File(rootDir, path);
        final String[] fileNames = srcDir.list();
        final List<String> classNames = new ArrayList<>();

        if (fileNames != null) {
            for (String fileName : fileNames) {
                if (fileName.endsWith(JAVA_EXT)) {
                    classNames.add(packageName + "." + fileName.replace(JAVA_EXT, ""));
                }
            }
        }
        return classNames;
    }
}
