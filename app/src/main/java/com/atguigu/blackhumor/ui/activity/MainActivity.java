package com.atguigu.blackhumor.ui.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.ContentUris;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.design.internal.NavigationMenuView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.anye.greendao.gen.UserDao;
import com.atguigu.blackhumor.R;
import com.atguigu.blackhumor.application.MyApplication;
import com.atguigu.blackhumor.mvp.view.sildefragment.CollectionFragment;
import com.atguigu.blackhumor.mvp.view.sildefragment.FavouriteFragment;
import com.atguigu.blackhumor.mvp.view.sildefragment.HistoryFragment;
import com.atguigu.blackhumor.mvp.view.sildefragment.ThemeFragment;
import com.atguigu.blackhumor.mvp.view.sildefragment.ViewFragment;
import com.atguigu.blackhumor.mvp.view.sildefragment.WalletFragment;
import com.atguigu.blackhumor.service.entity.User;
import com.atguigu.blackhumor.ui.fragment.BaseFragment;
import com.atguigu.blackhumor.ui.sildefragment.MainFragment;
import com.atguigu.blackhumor.utils.BitmapUtils;
import com.atguigu.blackhumor.utils.ThemeHelper;
import com.bilibili.magicasakura.utils.ThemeUtils;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {

    private static final String SWITCH_MODE_KEY = "mode_key";
    @Bind(R.id.nav_view)
    NavigationView navView;
    @Bind(R.id.drawer_layout)
    DrawerLayout drawerLayout;
    @Bind(R.id.fl_main)
    FrameLayout flMain;
    /**
     * 存放fragment的集合
     */
    private List<BaseFragment> fragments;
    /**
     * 添加的fragment在集合中的位置
     */
    private int position;
    /**
     * 缓存的fragment
     */
    private Fragment tempFragment;
    private ImageView ivMain;
    private UserDao mUserDao;
    private TextView mUserName;
    private String name1;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;
    private FileInputStream fis;
    //放主题的集合
    int[] themes = {ThemeHelper.CARD_SAKURA,ThemeHelper.CARD_HOPE,ThemeHelper.CARD_STORM,ThemeHelper.CARD_WOOD,
            ThemeHelper.CARD_LIGHT,ThemeHelper.CARD_THUNDER,ThemeHelper.CARD_SAND,ThemeHelper.CARD_FIREY};
    //表示选择哪个主题
    private int postion;

    @Override
    protected void initListener() {
        navView.setNavigationItemSelectedListener(this);
        View headerView = navView.getHeaderView(0);
        ivMain = (ImageView) headerView.findViewById(R.id.user_avatar_view);
        ImageView ivSelectMode = (ImageView) headerView.findViewById(R.id.iv_head_switch_mode);
        mUserName = (TextView) headerView.findViewById(R.id.user_name);
        TextView mUserSign = (TextView) headerView.findViewById(R.id.user_other_info);
        //设置用户名 签名
        if (name1 != null) {
            mUserName.setText(name1);
        } else {
            mUserName.setText(getResources().getText(R.string.username));
        }

        mUserSign.setText(getResources().getText(R.string.about_user_head_layout));
        ivMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chagerUserIcon();
            }
        });
        ivSelectMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                postion++;
                if (postion < themes.length) {

                } else {
                    postion = 0;
                }
                onConfirm(themes[postion]);
            }
        });
        NavigationMenuView childAt = (NavigationMenuView) navView.getChildAt(0);
        childAt.setVerticalScrollBarEnabled(false);
    }
    //确定选择哪个主题的方法
    private void onConfirm(int currentTheme) {
        if (ThemeHelper.getTheme(MainActivity.this) != currentTheme) {
            ThemeHelper.setTheme(MainActivity.this, currentTheme);
            ThemeUtils.refreshUI(MainActivity.this, new ThemeUtils.ExtraRefreshable() {
                        @Override
                        public void refreshGlobal(Activity activity) {
                            //for global setting, just do once
                            if (Build.VERSION.SDK_INT >= 21) {
                                final MainActivity context = MainActivity.this;
                                ActivityManager.TaskDescription taskDescription = new ActivityManager.TaskDescription(null, null, ThemeUtils.getThemeAttrColor(context, android.R.attr.colorPrimary));
                                setTaskDescription(taskDescription);
                                getWindow().setStatusBarColor(ThemeUtils.getColorById(context, R.color.theme_color_primary_dark));
                            }
                        }

                        @Override
                        public void refreshSpecificView(View view) {
                            //TODO: will do this for each traversal
                        }
                    }
            );
           /* View view = findViewById(R.id.snack_layout);
            if (view != null) {
                TextView textView = (TextView) view.findViewById(R.id.content);
                textView.setText(getSnackContent(currentTheme));
                SnackAnimationUtil.with(this, R.anim.snack_in, R.anim.snack_out)
                        .setDismissDelayTime(1000)
                        .setTarget(view)
                        .play();
            }*/
        }
    }

    private String changeName[] = {"相机", "相册"};

    //更换头像
    private void chagerUserIcon() {
        new AlertDialog.Builder(this)
                .setTitle("选择方式")
                .setItems(changeName, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //which是数组的下标
                        if (which == 0) {
                            //打开系统拍照程序，选择拍照图片
                            Intent camera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                            startActivityForResult(camera, 0);
                        } else {
                            //相册
                            //打开系统图库程序，选择图片
                            Intent picture = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                            startActivityForResult(picture, 1);
                        }
                    }
                })
                .show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0 && resultCode == RESULT_OK && data != null) {
            //相机
            //拍照
            Bundle bundle = data.getExtras();
            // 获取相机返回的数据，并转换为图片格式
            Bitmap bitmap = (Bitmap) bundle.get("data");
            //处理成圆形头像
            Bitmap circleBitmap = BitmapUtils.circleBitmap(bitmap);
            //设置图片
            ivMain.setImageBitmap(circleBitmap);
            //保存图片
            saveImage(bitmap);
            //uploadImage(bitmap);  //压缩
        } else if (data != null) {
            //图库 解析图库的操作，跟android系统有很大相关性。不同的系统使用uri的authority有很大不同。
            Uri selectedImage = data.getData();
            //android各个不同的系统版本,对于获取外部存储上的资源，返回的Uri对象都可能各不一样,
            // 所以要保证无论是哪个系统版本都能正确获取到图片资源的话就需要针对各种情况进行一个处理了
            //这里返回的uri情况就有点多了
            //在4.4.2之前返回的uri是:content://media/external/images/media/3951或者file://....
            // 在4.4.2返回的是content://com.android.providers.media.documents/document/image
            String pathResult = getPath(selectedImage);
            //存储--->内存
            Bitmap decodeFile = BitmapFactory.decodeFile(pathResult);
            //bitmap圆形裁剪
            Bitmap circleImage = BitmapUtils.circleBitmap(decodeFile);
            //加载显示
            ivMain.setImageBitmap(circleImage);
            //上传到服务器（省略）
            //保存到本地
            saveImage(decodeFile);
        }
    }

    /**
     * 根据系统相册选择的文件获取路径
     *
     * @param uri
     */
    @SuppressLint("NewApi")
    private String getPath(Uri uri) {
        int sdkVersion = Build.VERSION.SDK_INT;
        //高于4.4.2的版本
        if (sdkVersion >= 19) {
            Log.e("TAG", "uri auth: " + uri.getAuthority());
            if (isExternalStorageDocument(uri)) {
                String docId = DocumentsContract.getDocumentId(uri);
                String[] split = docId.split(":");
                String type = split[0];
                if ("primary".equalsIgnoreCase(type)) {
                    return Environment.getExternalStorageDirectory() + "/" + split[1];
                }
            } else if (isDownloadsDocument(uri)) {
                final String id = DocumentsContract.getDocumentId(uri);
                final Uri contentUri = ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"),
                        Long.valueOf(id));
                return getDataColumn(this, contentUri, null, null);
            } else if (isMediaDocument(uri)) {
                final String docId = DocumentsContract.getDocumentId(uri);
                final String[] split = docId.split(":");
                final String type = split[0];

                Uri contentUri = null;
                if ("image".equals(type)) {
                    contentUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                } else if ("video".equals(type)) {
                    contentUri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                } else if ("audio".equals(type)) {
                    contentUri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                }
                final String selection = "_id=?";
                final String[] selectionArgs = new String[]{split[1]};
                return getDataColumn(this, contentUri, selection, selectionArgs);
            } else if (isMedia(uri)) {
                String[] proj = {MediaStore.Images.Media.DATA};
                Cursor actualimagecursor = this.managedQuery(uri, proj, null, null, null);
                int actual_image_column_index = actualimagecursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
                actualimagecursor.moveToFirst();
                return actualimagecursor.getString(actual_image_column_index);
            }


        } else if ("content".equalsIgnoreCase(uri.getScheme())) {
            // Return the remote address
            if (isGooglePhotosUri(uri))
                return uri.getLastPathSegment();
            return getDataColumn(this, uri, null, null);
        }
        // File
        else if ("file".equalsIgnoreCase(uri.getScheme())) {
            return uri.getPath();
        }
        return null;
    }

    private File filesDir;
    private FileOutputStream os;

    private void saveImage(Bitmap bitmap) {
        try {
            //判断是否挂载了sd卡
            if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
                //外部存储路径
                filesDir = getExternalFilesDir("");
            } else {
                filesDir = getFilesDir(); //内部存储路径
            }
            //全路径
            File path = new File(filesDir, "123.png");
            //输出流
            os = new FileOutputStream(path);
            //第一个参数是图片的格式，第二个参数是图片的质量数值大的大质量高，第三个是输出流
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, os);
            //保存当前是否有更新
            saveImage(true);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (os != null) {
                    os.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void initData() {
        fragments = new ArrayList<>();
        fragments.add(new MainFragment());
        fragments.add(new ViewFragment());
        fragments.add(new CollectionFragment());
        fragments.add(new HistoryFragment());
        fragments.add(new FavouriteFragment());
        fragments.add(new WalletFragment());
        fragments.add(new ThemeFragment());
        Fragment baseFragment = fragments.get(0);
        switchFragment(baseFragment);
        //获取sp中存储的当前登录的用户的名字
        getData();
        mUserDao = MyApplication.getInstances().getDaoSession().getUserDao();
        SharedPreferences sp = getSharedPreferences("loginState", MODE_PRIVATE);
        //判断当前是否是登录的状态
        if (sp.getBoolean("islogin", false)) {
            List<User> users = mUserDao.loadAll();
            for (User username : users) {
                String name = username.getName();
                if (name.equals(name1)) {
                    //设置数据
                    if (mUserName != null) {
                        mUserName.setText(name);
                    }
                }
            }
        }
        setPic();
    }

    private void setPic() {
        //判断是否保存用户的图片
        if (isUpdate()) {
            //如果改变过，说明设置的头像
            File filesDir = null;
            FileInputStream fis = null;
            try {
                //判断是否挂载了sd卡
                if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
                    //外部存储路径
                    filesDir = getExternalFilesDir("");
                } else {
                    filesDir = getFilesDir(); //内部存储路径
                }
                //全路径
                File path = new File(filesDir, "123.png");
                if (path.exists()) {
                    //找到存贮图片的路径开始读取
                    fis = new FileInputStream(path);
                    Bitmap bitmap = BitmapFactory.decodeStream(fis);
                    //变成圆形
                    Bitmap circleBitmap = BitmapUtils.circleBitmap(bitmap);
                    if (ivMain!=null){

                        ivMain.setImageBitmap(circleBitmap);
                    }
                    //读取完以后布尔值改成false
//                    activity.saveImage(false);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (fis != null) {
                        fis.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void getData() {
        SharedPreferences sp = getSharedPreferences("user_info", MODE_PRIVATE);
        name1 = sp.getString("name", "Hero丿残月");
    }

    @Override
    protected void initTitle() {

    }

    @Override
    public int getLayoutid() {
        return R.layout.silde_layout;
    }

    @Override
    protected void onResume() {
        super.onResume();
        setPic();
    }

    /**
     * 第一次menu显示的时候调用的
     *
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    /**
     * 也就是从第二次点击menu按钮显示的时候都会调用这个
     *
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private long time = 0;

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            if (System.currentTimeMillis() - time > 2000) {
                Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
                time = System.currentTimeMillis();
            } else {
                finish();
            }
        }
    }

    /**
     * 这个是对侧滑中的选择时回调的方法
     *
     * @param item
     * @return
     */
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.main_home) {
            position = 0;
        } else if (id == R.id.main_vip) {
            //大会员
            startActivity(new Intent(MainActivity.this, VipActivity.class));
        } else if (id == R.id.main_integral) {

        } else if (id == R.id.main_cache) {
            // 离线缓存
            startActivity(new Intent(MainActivity.this, OffLineDownloadActivity.class));
        } else if (id == R.id.main_later) {
            position = 1;
        } else if (id == R.id.main_collection) {
            position = 2;
        } else if (id == R.id.main_history) {
            position = 3;
        } else if (id == R.id.main_like) {
            position = 4;
        } else if (id == R.id.main_wallet) {
            position = 5;
        } else if (id == R.id.main_choose) {
            position = 6;
        } else if (id == R.id.setting_help) {

        }
        drawerLayout.closeDrawer(GravityCompat.START);
        //根据对应的位置切换fragment,先获取当前的fragment
        Fragment currentFragment = fragments.get(position);
        switchFragment(currentFragment);
        return true;
    }

    private void switchFragment(Fragment currentFragment) {
        //缓存的和当前的不是一个fragment才去进行切换
        if (tempFragment != currentFragment) {
            //得到管理类
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            //如果没有添加就先进行添加，指的是没有添加到容器中的意思
            if (!currentFragment.isAdded()) {
                //隐藏缓存的fragment
                if (tempFragment != null) {//校验
                    ft.hide(tempFragment);
                }
                //添加
                ft.add(R.id.fl_main, currentFragment, null);
            } else {//如果当前的被添加了就直接显示
                //隐藏缓存
                if (tempFragment != null) {//校验
                    ft.hide(tempFragment);
                }
                //直接显示
                ft.show(currentFragment);
            }
            //进行事务提交
            ft.commit();
            //在这进行缓存（把当前的fragment赋值给缓存）
            tempFragment = currentFragment;
        }
    }

    /**
     * uri路径查询字段
     *
     * @param context
     * @param uri
     * @param selection
     * @param selectionArgs
     * @return
     */
    public static String getDataColumn(Context context, Uri uri, String selection, String[] selectionArgs) {
        Cursor cursor = null;
        final String column = "_data";
        final String[] projection = {column};
        try {
            cursor = context.getContentResolver().query(uri, projection, selection, selectionArgs, null);
            if (cursor != null && cursor.moveToFirst()) {
                final int index = cursor.getColumnIndexOrThrow(column);
                return cursor.getString(index);
            }
        } finally {
            if (cursor != null)
                cursor.close();
        }
        return null;
    }

    private boolean isExternalStorageDocument(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    public static boolean isDownloadsDocument(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    public static boolean isMediaDocument(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }

    public static boolean isMedia(Uri uri) {
        return "media".equals(uri.getAuthority());
    }

    /**
     * @param uri The Uri to check.
     * @return Whether the Uri authority is Google Photos.
     */
    public static boolean isGooglePhotosUri(Uri uri) {
        return "com.google.android.apps.photos.content".equals(uri.getAuthority());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Main Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}
