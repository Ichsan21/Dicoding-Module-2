package com.rizky92.dicodingsubmissionv2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity implements View.OnClickListener {
    TextView tvNama, tvAnnounced, tvStatus, tvNetwork, tvDimensions, tvWeight, tvBuild, tvSim, tvType, tvSize, tvRes, tvOs, tvChipset, tvCpu, tvGpu, tvRam, tvInternal, tvExternal, tvRearCam, tvRearFeat, tvRearVideo, tvFrontCam, tvFrontFeat, tvFrontVideo, tvSpeaker, tvJack, tvWlan, tvBluetooth, tvRadio, tvUsb, tvSensors, tvBattery, tvPrice;
    ImageView img;

    public static final String EXTRA_NAMA = "extra_nama";
    public static final String EXTRA_PRICE = "extra_price";

    public static final String EXTRA_ANNOUNCED = "extra_announced";
    public static final String EXTRA_STATUS = "extra_status";

    public static final String EXTRA_DIMENSIONS = "extra_dimensions";
    public static final String EXTRA_WEIGHT = "extra_weight";
    public static final String EXTRA_BUILD = "extra_build";
    public static final String EXTRA_SIM = "extra_sim";

    public static final String EXTRA_TYPE = "extra_type";
    public static final String EXTRA_SIZE = "extra_size";
    public static final String EXTRA_RES = "extra_res";

    public static final String EXTRA_OS = "extra_os";
    public static final String EXTRA_CHIPSET = "extra_chipset";
    public static final String EXTRA_CPU = "extra_cpu";
    public static final String EXTRA_GPU = "extra_gpu";

    public static final String EXTRA_RAM = "extra_ram";
    public static final String EXTRA_INTERNAL = "extra_internal";
    public static final String EXTRA_EXTERNAL = "extra_external";

    public static final String EXTRA_REARCAM = "extra_rearcam";
    public static final String EXTRA_REARFEAT = "extra_rearfeat";
    public static final String EXTRA_REARVIDEO = "extra_rearvideo";

    public static final String EXTRA_FRONTCAM = "extra_frontcam";
    public static final String EXTRA_FRONTFEAT = "extra_frontfeat";
    public static final String EXTRA_FRONTVIDEO = "extra_frontvideo";

    public static final String EXTRA_SPEAKER = "extra_speaker";
    public static final String EXTRA_JACK = "extra_jack";

    public static final String EXTRA_WLAN = "extra_wlan";
    public static final String EXTRA_BLUETOOTH = "extra_bluetooth";
    public static final String EXTRA_RADIO = "extra_radio";
    public static final String EXTRA_NETWORK = "extra_network";

    public static final String EXTRA_USB = "extra_usb";
    public static final String EXTRA_SENSORS = "extra_sensors";
    public static final String EXTRA_BATTERY = "extra_battery";

    public static final String EXTRA_IMG = "extra_img";

    private void extra_extra() {
        tvNama.setText(getIntent().getStringExtra(EXTRA_NAMA));
        tvPrice.setText(getIntent().getStringExtra(EXTRA_PRICE));

        tvAnnounced.setText(getIntent().getStringExtra(EXTRA_ANNOUNCED));
        tvStatus.setText(getIntent().getStringExtra(EXTRA_STATUS));

        tvDimensions.setText(getIntent().getStringExtra(EXTRA_DIMENSIONS));
        tvWeight.setText(getIntent().getStringExtra(EXTRA_WEIGHT));
        tvBuild.setText(getIntent().getStringExtra(EXTRA_BUILD));
        tvSim.setText(getIntent().getStringExtra(EXTRA_SIM));

        tvType.setText(getIntent().getStringExtra(EXTRA_TYPE));
        tvSize.setText(getIntent().getStringExtra(EXTRA_SIZE));
        tvRes.setText(getIntent().getStringExtra(EXTRA_RES));

        tvOs.setText(getIntent().getStringExtra(EXTRA_OS));
        tvChipset.setText(getIntent().getStringExtra(EXTRA_CHIPSET));
        tvCpu.setText(getIntent().getStringExtra(EXTRA_CPU));
        tvGpu.setText(getIntent().getStringExtra(EXTRA_GPU));

        tvRam.setText(getIntent().getStringExtra(EXTRA_RAM));
        tvInternal.setText(getIntent().getStringExtra(EXTRA_INTERNAL));
        tvExternal.setText(getIntent().getStringExtra(EXTRA_EXTERNAL));

        tvRearCam.setText(getIntent().getStringExtra(EXTRA_REARCAM));
        tvRearFeat.setText(getIntent().getStringExtra(EXTRA_REARFEAT));
        tvRearVideo.setText(getIntent().getStringExtra(EXTRA_REARVIDEO));

        tvFrontCam.setText(getIntent().getStringExtra(EXTRA_FRONTCAM));
        tvFrontFeat.setText(getIntent().getStringExtra(EXTRA_FRONTFEAT));
        tvFrontVideo.setText(getIntent().getStringExtra(EXTRA_FRONTVIDEO));

        tvSpeaker.setText(getIntent().getStringExtra(EXTRA_SPEAKER));
        tvJack.setText(getIntent().getStringExtra(EXTRA_JACK));

        tvWlan.setText(getIntent().getStringExtra(EXTRA_WLAN));
        tvBluetooth.setText(getIntent().getStringExtra(EXTRA_BLUETOOTH));
        tvRadio.setText(getIntent().getStringExtra(EXTRA_RADIO));
        tvNetwork.setText(getIntent().getStringExtra(EXTRA_NETWORK));

        tvUsb.setText(getIntent().getStringExtra(EXTRA_USB));
        tvSensors.setText(getIntent().getStringExtra(EXTRA_SENSORS));
        tvBattery.setText(getIntent().getStringExtra(EXTRA_BATTERY));

        byte[] bArr = getIntent().getExtras().getByteArray(EXTRA_IMG);
        Bitmap bmp = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);

        img.setImageBitmap(bmp);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Button btnOke = findViewById(R.id.btn_oke);
        btnOke.setOnClickListener(this);

        img = findViewById(R.id.img_item_foto);

        tvNama = findViewById(R.id.tv_name);
        tvPrice = findViewById(R.id.tv_price);

        tvAnnounced = findViewById(R.id.tv_launch_announced);
        tvStatus = findViewById(R.id.tv_launch_status);

        tvDimensions = findViewById(R.id.tv_body_dimensions);
        tvWeight = findViewById(R.id.tv_body_weight);
        tvBuild = findViewById(R.id.tv_body_build);
        tvSim = findViewById(R.id.tv_body_sim);

        tvType = findViewById(R.id.tv_display_type);
        tvSize = findViewById(R.id.tv_display_size);
        tvRes = findViewById(R.id.tv_display_resolution);

        tvOs = findViewById(R.id.tv_platform_os);
        tvChipset = findViewById(R.id.tv_platform_chipset);
        tvCpu = findViewById(R.id.tv_platform_cpu);
        tvGpu = findViewById(R.id.tv_platform_gpu);

        tvRam = findViewById(R.id.tv_memory_ram);
        tvInternal = findViewById(R.id.tv_memory_internal);
        tvExternal = findViewById(R.id.tv_memory_external);

        tvRearCam = findViewById(R.id.tv_r_cam_main);
        tvRearFeat = findViewById(R.id.tv_r_cam_feat);
        tvRearVideo = findViewById(R.id.tv_r_cam_vid);

        tvFrontCam = findViewById(R.id.tv_f_cam_main);
        tvFrontFeat = findViewById(R.id.tv_f_cam_feat);
        tvFrontVideo = findViewById(R.id.tv_f_cam_vid);

        tvSpeaker = findViewById(R.id.tv_sound_speaker);
        tvJack = findViewById(R.id.tv_sound_jack);

        tvWlan = findViewById(R.id.tv_comm_wlan);
        tvBluetooth = findViewById(R.id.tv_comm_bt);
        tvRadio = findViewById(R.id.tv_comm_radio);
        tvNetwork = findViewById(R.id.tv_comm_network);

        tvUsb = findViewById(R.id.tv_feat_usb);
        tvSensors = findViewById(R.id.tv_feat_sensors);
        tvBattery = findViewById(R.id.tv_feat_battery);

        extra_extra();
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_oke) {
            Intent backToMain = new Intent(DetailActivity.this, MainActivity.class);
            startActivity(backToMain);
        }
    }
}
