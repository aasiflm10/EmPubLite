package com.commonsware.empublite;

import android.net.Uri;

import java.io.File;
import java.util.List;

public class BookContents {

    List<BookContents.Chapter> chapters;
    File baseDir = null;

    void setBaseDir(File baseDir) {
        this.baseDir = baseDir;
    }
    String getChapterPath(int position) {
        String file = getChapterFile(position);

        if(baseDir == null) {
            return ("file:///android_asset/book/" + file);
        }

        return (Uri.fromFile(new File(baseDir, file)).toString());
    }

    int getChapterCount() {

        return (chapters.size());
    }

    String getChapterFile(int position) {

        return (chapters.get(position).file);
    }

    String getChapterTitle(int position) {
        return (chapters.get(position).title);
    }

    static class Chapter {
        String file;
        String title;
    }
}
