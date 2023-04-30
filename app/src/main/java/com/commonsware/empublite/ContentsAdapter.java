package com.commonsware.empublite;

import android.app.Activity;
import android.app.Fragment;
import android.support.v13.app.FragmentStatePagerAdapter;

public class ContentsAdapter extends FragmentStatePagerAdapter {
    final BookContents contents;

    public ContentsAdapter(Activity ctxt, BookContents contents) {
        super(ctxt.getFragmentManager());

        this.contents = contents;
    }


    @Override
    public Fragment getItem(int position) {
        String path = contents.getChapterFile(position);

        return (SimpleContentFragment.newInstance(contents.getChapterPath(position)));
    }

    @Override
    public int getCount() {
        return (contents.getChapterCount());
    }

    @Override
    public CharSequence getPageTitle( int position) {
        return (contents.getChapterTitle(position));
    }
}
/*
A ViewPager needs a PagerAdapter to populate its content, much like a ListView
needs a ListAdapter. We cannot completely construct a PagerAdapter yet, as we
still need to learn how to load up our book content from files. But, we can get partway towards having a useful PagerAdapter now.
 */