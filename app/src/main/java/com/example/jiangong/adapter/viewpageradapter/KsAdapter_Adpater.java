package com.example.jiangong.adapter.viewpageradapter;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class KsAdapter_Adpater extends FragmentPagerAdapter {

    private List<String> titlelist;
    private List<Fragment> fragmentList;

    public KsAdapter_Adpater(@NonNull FragmentManager fm, List<String> titlelist, List<Fragment> fragmentList) {
        super(fm);
        this.titlelist = titlelist;
        this.fragmentList = fragmentList;
    }

    public KsAdapter_Adpater(@NonNull FragmentManager fm, int behavior, List<String> titlelist, List<Fragment> fragmentList) {
        super(fm, behavior);
        this.titlelist = titlelist;
        this.fragmentList = fragmentList;
    }

    public KsAdapter_Adpater(@NonNull FragmentManager fm, int behavior, List<Fragment> fragmentList) {
        super(fm, behavior);
        this.fragmentList = fragmentList;
    }

    public KsAdapter_Adpater(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titlelist.get(position);
    }
}
