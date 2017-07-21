package com.test.zzw.zzwapp.activity;

import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TextView;

import com.test.zzw.zzwapp.R;
import com.test.zzw.zzwapp.ijkplayer.application.Settings;
import com.test.zzw.zzwapp.ijkplayer.content.RecentMediaStorage;
import com.test.zzw.zzwapp.ijkplayer.widget.media.AndroidMediaController;
import com.test.zzw.zzwapp.ijkplayer.widget.media.IjkVideoView;

import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/**
 * Created by zzw on 2017/7/19.
 */

public class IjkPlayerActivity extends MyBaseAppCompatActivity{

    private static final String TAG = "IjkPlayerActivity";

    private String mVideoPath;
    private Uri mVideoUri;

    private AndroidMediaController mMediaController;
    private IjkVideoView mVideoView;
    private TextView mToastTextView;
    private TableLayout mHudView;
    private DrawerLayout mDrawerLayout;
    private ViewGroup mRightDrawer;

    private Settings mSettings;
    private boolean mBackPressed;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        mSettings = new Settings(this);

        // handle arguments
        mVideoPath = "http://live.hkstv.hk.lxdns.com/live/hks/playlist.m3u8";

//        Intent intent = getIntent();
//        String intentAction = intent.getAction();
//        if (!TextUtils.isEmpty(intentAction)) {
//            if (intentAction.equals(Intent.ACTION_VIEW)) {
//                mVideoPath = intent.getDataString();
//            } else if (intentAction.equals(Intent.ACTION_SEND)) {
//                mVideoUri = Uri.parse("http://v1.one-tv.com:1935/live/mpegts.stream/playlist.m3u8");//intent.getParcelableExtra(Intent.EXTRA_STREAM);
//                if (Build.VERSION.SDK_INT < Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
//                    String scheme = mVideoUri.getScheme();
//                    if (TextUtils.isEmpty(scheme)) {
//                        Log.e(TAG, "Null unknown scheme\n");
//                        finish();
//                        return;
//                    }
//                    if (scheme.equals(ContentResolver.SCHEME_ANDROID_RESOURCE)) {
//                        mVideoPath = mVideoUri.getPath();
//                    } else if (scheme.equals(ContentResolver.SCHEME_CONTENT)) {
//                        Log.e(TAG, "Can not resolve content below Android-ICS\n");
//                        finish();
//                        return;
//                    } else {
//                        Log.e(TAG, "Unknown scheme " + scheme + "\n");
//                        finish();
//                        return;
//                    }
////                }
////            }
//        }

        if (!TextUtils.isEmpty(mVideoPath)) {
            new RecentMediaStorage(this).saveUrlAsync(mVideoPath);
        }

        // init UI
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        mMediaController = new AndroidMediaController(this, false);
        mMediaController.setSupportActionBar(actionBar);

        mToastTextView = (TextView) findViewById(R.id.toast_text_view);
        mHudView = (TableLayout) findViewById(R.id.hud_view);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mRightDrawer = (ViewGroup) findViewById(R.id.right_drawer);

        mDrawerLayout.setScrimColor(Color.TRANSPARENT);

        // init player
        IjkMediaPlayer.loadLibrariesOnce(null);
        IjkMediaPlayer.native_profileBegin("libijkplayer.so");

        mVideoView = (IjkVideoView) findViewById(R.id.video_view);
        mVideoView.setMediaController(mMediaController);
        mVideoView.setHudView(mHudView);
        // prefer mVideoPath
        if (mVideoPath != null)
            mVideoView.setVideoPath(mVideoPath);
        else if (mVideoUri != null)
            mVideoView.setVideoURI(mVideoUri);
        else {
            Log.e(TAG, "Null Data Source\n");
            finish();
            return;
        }
        mVideoView.start();

    }
}
