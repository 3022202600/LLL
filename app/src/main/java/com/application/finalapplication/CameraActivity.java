package com.application.finalapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.VideoView;

import java.io.File;

public class CameraActivity extends AppCompatActivity {

    private ImageView iv;

    private VideoView videoView;

    private final static int FLAG_REQUEST_SYSTEM_IMAGE = 0;

    private final static int FLAG_REQUEST_CAMERA_IMAGE = 1;

    private final static int FLAG_REQUEST_CAMERA_VIDEO = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        iv = (ImageView) findViewById(R.id.iv);
        videoView = (VideoView) findViewById(R.id.video);
    }

    public void doclick(View view) {
        switch (view.getId()) {
            case R.id.btn_pick_imager:
                // TODO 选取系统相册图片
                Toast.makeText(this,"打开相册",Toast.LENGTH_SHORT).show();
                doPickImageFromSystem();
                break;
            case R.id.btn_open_pick_imager:
                // TODO 打开相机拍照
                Toast.makeText(this,"打开相机",Toast.LENGTH_LONG).show();
                doOpenCameraForImage();
                break;
        }
    }

    private void doPickImageFromSystem() {
        /**
         * 参数一:打开系统相册的ACTION
         * 参数二:返回数据的方式(从系统相册的数据库获取)
         */
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, FLAG_REQUEST_SYSTEM_IMAGE);
    }

    private void doOpenCameraForImage() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        //todo 仅当设置了MediaStore.EXTRA_OUTPUT参数时,系统将不再返回缩略图,而是会被完整保存以下路径
        intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(new File("/sdcard/test.jpg")));

        startActivityForResult(intent,FLAG_REQUEST_CAMERA_IMAGE);
    }

    private void doOpenCameraForVideo() {
        Intent intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(new File("/sdcard/test.mp4")));
        startActivityForResult(intent, FLAG_REQUEST_CAMERA_VIDEO);
    }

    //TODO　onActivityResul该方法根据requestCode返回码进行判断和处理数据
    @SuppressLint("MissingSuperCall")
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //当结果码为RESULT_OK时,表示用户有效
        if (resultCode == RESULT_OK) {
            Log.i("info", "确认用户操作");
            switch (requestCode) {
                case FLAG_REQUEST_SYSTEM_IMAGE:
                    //TODO 处理从相册返回的图片数据
                    Uri uri = data.getData();//使用getData方法获取要调用的接口
                    //第二个参数表示要查询的数据的字段名
                    Cursor c = getContentResolver().query(uri, new String[]{MediaStore.Images.Media.DATA}, null, null, null);
                    if (c != null) {
                        c.moveToFirst();
                        //通过游标来获取名为MediaStore.Images.Media.DATA字段的值
                        String path = c.getString(c.getColumnIndex(MediaStore.Images.Media.DATA));
                        iv.setImageBitmap(BitmapFactory.decodeFile(path));
                    }
                    break;
                case FLAG_REQUEST_CAMERA_IMAGE:
                    //TODO 处理从相机返回的图片数据
                    if (data != null) {
                        Bitmap bm = data.getParcelableExtra("data");
                        iv.setImageBitmap(bm);
                    } else {
                        Bitmap bm = BitmapFactory.decodeFile("/sdcard/test.jpg");
                        iv.setImageBitmap(bm);
                    }
                    break;
            }
        } else {
            Log.i("info", "取消用户操作");
        }
    }
}