package com.example.sm.myapplication3;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
//import android.support.test.espresso.core.deps.guava.io.ByteStreams;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.media.Image;
import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import android.support.v7.app.AlertDialog;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

//serial
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

import tw.com.prolific.driver.pl2303.PL2303Driver;
import tw.com.prolific.driver.pl2303.PL2303Driver.DataBits;
import tw.com.prolific.driver.pl2303.PL2303Driver.FlowControl;
import tw.com.prolific.driver.pl2303.PL2303Driver.Parity;
import tw.com.prolific.driver.pl2303.PL2303Driver.StopBits;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.hardware.usb.UsbManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.preference.PreferenceManager;
import android.text.format.Time;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
//serial

public class MainActivity extends AppCompatActivity {
    //serial
//    final byte[] bytesHello = new byte[] {(byte) 0xFA, (byte) 0xEF, 0x01, 0x01, 0x03};
//    final byte[] bytesHello2 = new byte[] {(byte) 0xFA, (byte) 0xEF, 0x01, 0x01, 0x04};

    private static final boolean SHOW_DEBUG = true;
    PL2303Driver mSerial;
    String TAG = "PL2303HXD_APLog";

    private PL2303Driver.BaudRate mBaudrate = PL2303Driver.BaudRate.B9600;
    private static final String ACTION_USB_PERMISSION = "com.prolific.pl2303hxdsimpletest.USB_PERMISSION";
    private static final String NULL = null;
    //serial

    private static final int REQUEST_ENABLE_BT = 1;
    BluetoothAdapter bluetoothAdapter;
    ArrayList<BluetoothDevice> pairedDeviceArrayList;
    TextView textInfo, textStatus, textByteCnt;
    ListView listViewPairedDevice;
    LinearLayout inputPane;
    ArrayAdapter<BluetoothDevice> pairedDeviceAdapter;
    private UUID myUUID;
    private final String UUID_STRING_WELL_KNOWN_SPP = "00001101-0000-1000-8000-00805F9B34FB";
    ThreadConnectBTdevice myThreadConnectBTdevice;
    ThreadConnected myThreadConnected;
    Button btnOn, btnOff, btnStop, btnUp, btnDown, btnSetStopStore, btnSetStop, btnGroup1Set, btnGroup2Set, btnGroup3Set, btnGroup4Set,
            btnGroup5Set, btnGroup6Set, btnGroup7Set, btnGroup8Set, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10, btn11, btn12,
            btn13, btn14, btn15, btn16, btn17, btn18, btn19, btn20, btn21, btn22, btn23, btn24, btn25, btn26, btn27, btn28, btn29, btn30,
            btn31, btn32, btn33, btn34, btn35,
            Group1, Group2, Group3, Group4, Group5, Group6, Group7, Group8,btn;
    LinearLayout option1, option2, option3, option4, main, main2, main3, main4, main5, main6, main7, main8, SetGroup, SetGroupButton,
            SetGroupButton2, SetGroupButton3, SetGroupButton4, SetGroupButton5, All,barForLight,barForUpdown,barForGroup,nameForgroup,
            nameForgroup2, nameForgroup3;
    ImageButton lampButton, upDownButton, Setting;




    int[] arr = new int[35];
    int[] dbgroup1 = new int[36];
    int[] dbgroup2 = new int[36];
    int[] dbgroup3 = new int[36];
    int[] dbgroup4 = new int[36];
    int[] dbgroup5 = new int[36];
    int[] dbgroup6 = new int[36];
    int[] dbgroup7 = new int[36];
    int[] dbgroup8 = new int[36];
    int[] menu = new int[2];
    int[] groupControl = new int[8];
    int[] btng = new int[35];
    int[] group = new int[8];
    int groupSize = 0;
    int arraySize = 0;
    int arraySizeforgroup = 0;
    byte[] OnArray = new byte[37];
    byte[] OffArray = new byte[37];
    byte[] UpArray = new byte[37];
    byte[] DownArray = new byte[37];
    byte[] StopArray = new byte[37];
    byte[] temp = new byte[35];
    byte[] tempControl = new byte[35];
    byte[] tempforgroup = new byte[35];
    byte[] tempControlforgroup = new byte[35];
    Button[] btngg = new Button[35];
    int a = OnArray[2];
    int b = OnArray[3];
    int C = OnArray[4];


    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textInfo = (TextView) findViewById(R.id.info);
        textStatus = (TextView) findViewById(R.id.status);
        textByteCnt = (TextView) findViewById(R.id.textbyteCnt);
        listViewPairedDevice = (ListView) findViewById(R.id.pairedlist);
        inputPane = (LinearLayout) findViewById(R.id.inputpane);
        lampButton = (ImageButton) findViewById(R.id.lamp);
        upDownButton = (ImageButton) findViewById(R.id.upDown);
        option1 = (LinearLayout) findViewById(R.id.aaaa);
        option2 = (LinearLayout) findViewById(R.id.bbbb);
        option3 = (LinearLayout) findViewById(R.id.cccc);
        option4 = (LinearLayout) findViewById(R.id.dddd);
        main = (LinearLayout) findViewById(R.id.main);
        main2 = (LinearLayout) findViewById(R.id.main2);
        main3 = (LinearLayout) findViewById(R.id.main3);
        main4 = (LinearLayout) findViewById(R.id.main4);
        main5 = (LinearLayout) findViewById(R.id.main5);
        main6 = (LinearLayout) findViewById(R.id.main6);
        main7 = (LinearLayout) findViewById(R.id.main7);
        main8 = (LinearLayout) findViewById(R.id.main8);
        SetGroup = (LinearLayout) findViewById(R.id.SetGroup);
        SetGroupButton = (LinearLayout) findViewById(R.id.SetGroupButton);
        SetGroupButton2 = (LinearLayout) findViewById(R.id.SetGroupButton2);
        SetGroupButton3 = (LinearLayout) findViewById(R.id.SetGroupButton3);
        SetGroupButton4 = (LinearLayout) findViewById(R.id.SetGroupButton4);
        SetGroupButton5 = (LinearLayout) findViewById(R.id.SetGroupButton5);
        All = (LinearLayout) findViewById(R.id.All);
        barForLight = (LinearLayout) findViewById(R.id.barForLight);
        barForUpdown = (LinearLayout) findViewById(R.id.barForUpDown);
        barForGroup = (LinearLayout) findViewById(R.id.barForGroup);
        nameForgroup  = (LinearLayout) findViewById(R.id.nameForgroup);
        nameForgroup2  = (LinearLayout) findViewById(R.id.nameForgroup2);
        nameForgroup3  = (LinearLayout) findViewById(R.id.nameForgroup3);

        // 그룹 부분의 그룹버튼
        btnGroup1Set = (Button) findViewById(R.id.Group1Set);
        btnGroup2Set = (Button) findViewById(R.id.Group2Set);
        btnGroup3Set = (Button) findViewById(R.id.Group3Set);
        btnGroup4Set = (Button) findViewById(R.id.Group4Set);
        btnGroup5Set = (Button) findViewById(R.id.Group5Set);
        btnGroup6Set = (Button) findViewById(R.id.Group6Set);
        btnGroup7Set = (Button) findViewById(R.id.Group7Set);
        btnGroup8Set = (Button) findViewById(R.id.Group8Set);

        //그룹 부분의 조명버튼
        btngg[0] = (Button) findViewById(R.id.btn1g);
        btngg[1] = (Button) findViewById(R.id.btn2g);
        btngg[2] = (Button) findViewById(R.id.btn3g);
        btngg[3] = (Button) findViewById(R.id.btn4g);
        btngg[4] = (Button) findViewById(R.id.btn5g);
        btngg[5] = (Button) findViewById(R.id.btn6g);
        btngg[6] = (Button) findViewById(R.id.btn7g);
        btngg[7] = (Button) findViewById(R.id.btn8g);
        btngg[8] = (Button) findViewById(R.id.btn9g);
        btngg[9] = (Button) findViewById(R.id.btn10g);
        btngg[10] = (Button) findViewById(R.id.btn11g);
        btngg[11] = (Button) findViewById(R.id.btn12g);
        btngg[12] = (Button) findViewById(R.id.btn13g);
        btngg[13] = (Button) findViewById(R.id.btn14g);
        btngg[14] = (Button) findViewById(R.id.btn15g);
        btngg[15] = (Button) findViewById(R.id.btn16g);
        btngg[16] = (Button) findViewById(R.id.btn17g);
        btngg[17] = (Button) findViewById(R.id.btn18g);
        btngg[18] = (Button) findViewById(R.id.btn19g);
        btngg[19] = (Button) findViewById(R.id.btn20g);
        btngg[20] = (Button) findViewById(R.id.btn21g);
        btngg[21] = (Button) findViewById(R.id.btn22g);
        btngg[22] = (Button) findViewById(R.id.btn23g);
        btngg[23] = (Button) findViewById(R.id.btn24g);
        btngg[24] = (Button) findViewById(R.id.btn25g);
        btngg[25] = (Button) findViewById(R.id.btn26g);
        btngg[26] = (Button) findViewById(R.id.btn27g);
        btngg[27] = (Button) findViewById(R.id.btn28g);
        btngg[28] = (Button) findViewById(R.id.btn29g);
        btngg[29] = (Button) findViewById(R.id.btn30g);
        btngg[30] = (Button) findViewById(R.id.btn31g);
        btngg[31] = (Button) findViewById(R.id.btn32g);
        btngg[32] = (Button) findViewById(R.id.btn33g);
        btngg[33] = (Button) findViewById(R.id.btn34g);
        btngg[34] = (Button) findViewById(R.id.btn35g);


        //컨트롤 부분 조명
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);
        btn9 = (Button) findViewById(R.id.btn9);
        btn10 = (Button) findViewById(R.id.btn10);
        btn11 = (Button) findViewById(R.id.btn11);
        btn12 = (Button) findViewById(R.id.btn12);
        btn13 = (Button) findViewById(R.id.btn13);
        btn14 = (Button) findViewById(R.id.btn14);
        btn15 = (Button) findViewById(R.id.btn15);
        btn16 = (Button) findViewById(R.id.btn16);
        btn17 = (Button) findViewById(R.id.btn17);
        btn18 = (Button) findViewById(R.id.btn18);
        btn19 = (Button) findViewById(R.id.btn19);
        btn20 = (Button) findViewById(R.id.btn20);
        btn21 = (Button) findViewById(R.id.btn21);
        btn22 = (Button) findViewById(R.id.btn22);
        btn23 = (Button) findViewById(R.id.btn23);
        btn24 = (Button) findViewById(R.id.btn24);
        btn25 = (Button) findViewById(R.id.btn25);
        btn26 = (Button) findViewById(R.id.btn26);
        btn27 = (Button) findViewById(R.id.btn27);
        btn28 = (Button) findViewById(R.id.btn28);
        btn29 = (Button) findViewById(R.id.btn29);
        btn30 = (Button) findViewById(R.id.btn30);
        btn31 = (Button) findViewById(R.id.btn31);
        btn32 = (Button) findViewById(R.id.btn32);
        btn33 = (Button) findViewById(R.id.btn33);
        btn34 = (Button) findViewById(R.id.btn34);
        btn35 = (Button) findViewById(R.id.btn35);

        //컨트롤 부분 그룹
        Group1 = (Button) findViewById(R.id.Group1);
        Group2 = (Button) findViewById(R.id.Group2);
        Group3 = (Button) findViewById(R.id.Group3);
        Group4 = (Button) findViewById(R.id.Group4);
        Group5 = (Button) findViewById(R.id.Group5);
        Group6 = (Button) findViewById(R.id.Group6);
        Group7 = (Button) findViewById(R.id.Group7);
        Group8 = (Button) findViewById(R.id.Group8);


         final DBHelper dbHelper = new DBHelper(getApplicationContext(), "bb1a.db", null, 1);
        //액션바 색깔 바꾸기
        final ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(0xFF78a58f));

        final AlertDialog.Builder builder = new AlertDialog.Builder(this);     // 여기서 this는 Activity의 this
        //serial control

        // get service
        mSerial = new PL2303Driver((UsbManager) getSystemService(Context.USB_SERVICE),
                this, ACTION_USB_PERMISSION);
        // check USB host function.
        if (!mSerial.PL2303USBFeatureSupported()) {
            Toast.makeText(this, "No Support USB host API", Toast.LENGTH_SHORT)
                    .show();
            Log.d(TAG, "No Support USB host API");
            mSerial = null;
        }
        //serial control


        btnOn = (Button) findViewById(R.id.On);
        btnOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setupOn();
                setupOn2();
                if (myThreadConnected != null) {
                    myThreadConnected.write(OnArray);
                }
                if(mSerial.PL2303Device_IsHasPermission()){
                    writeDataToSerial2();
                }
                resetOnArray();
            }
        });

        btnOff = (Button) findViewById(R.id.Off);
        btnOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setupOff();
                setupOff2();
                if (myThreadConnected != null) {
                    myThreadConnected.write(OffArray);
                }
                if(mSerial.PL2303Device_IsHasPermission()){
                    writeDataToSerial();
                }
                resetOffArray();
            }
        });

        btnUp = (Button) findViewById(R.id.Up);
        btnUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setupUp();
                setupUp2();
                if (myThreadConnected != null) {
                    myThreadConnected.write(UpArray);
                }
                if(mSerial.PL2303Device_IsHasPermission()){
                    writeDataToSerial3();
                }
                resetUpArray();
            }
        });

        btnDown = (Button) findViewById(R.id.Down);
        btnDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setupDown();
                setupDown2();
                if (myThreadConnected != null) {
                    myThreadConnected.write(DownArray);
                }
                if(mSerial.PL2303Device_IsHasPermission()){
                    writeDataToSerial4();
                }
                resetDownArray();
            }
        });

        btnStop = (Button) findViewById(R.id.Stop);
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setupStop();
                setupStop2();
                if (myThreadConnected != null) {
                    myThreadConnected.write(StopArray);
                }
                if(mSerial.PL2303Device_IsHasPermission()){
                    writeDataToSerial();
                }
                resetStopArray();
            }
        });
        btnSetStop = (Button) findViewById(R.id.SetStop);
        btnSetStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (myThreadConnected != null) {
                }
            }
        });
        btnSetStopStore = (Button) findViewById(R.id.SetStopStore);
        btnSetStopStore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (myThreadConnected != null) {
                }
            }
        });


        if (!getPackageManager().hasSystemFeature(PackageManager.FEATURE_BLUETOOTH)) {
            Toast.makeText(this, "블루투스가 제공되지 않는 스마트폰입니다.", Toast.LENGTH_SHORT).show();
            finish();
            return;
        }
        //using the well-known SPP UUID
        myUUID = UUID.fromString(UUID_STRING_WELL_KNOWN_SPP);
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (bluetoothAdapter == null) {
            Toast.makeText(this, "블루투스가 제공되지 않는 스마트폰입니다.", Toast.LENGTH_SHORT).show();
            finish();
            return;
        }
        String stInfo = "이름 : " + bluetoothAdapter.getName() + "";
        textInfo.setText(stInfo);


        Button Group = (Button) findViewById(R.id.Group);
        //그룹모드에서 그룹설정
        Group.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (group[0] == 1) {
                    if(btng[0]+btng[1]+btng[2]+btng[3]+btng[4]+btng[5]+btng[6]+btng[7]+btng[8]+btng[9]+btng[10]+btng[11]+btng[12]+btng[13]+
                            btng[14]+btng[15]+btng[16]+btng[17]+btng[18]+btng[19]+btng[20]+btng[21]+btng[22]+btng[23]+btng[24]+btng[25]+btng[26]+btng[27]+
                            btng[28]+btng[29]+btng[30]+btng[31]+btng[32]+btng[33]+btng[34] != 0){
                        int arr1 = btng[0];int arr2 = btng[1];int arr3 = btng[2];int arr4 = btng[3];int arr5 = btng[4];int arr6 = btng[5];int arr7 = btng[6];
                        int arr8 = btng[7];int arr9 = btng[8];int arr10 = btng[9];int arr11 = btng[10];int arr12 = btng[11];int arr13 = btng[12];int arr14 = btng[13];
                        int arr15 = btng[14];int arr16 = btng[15];int arr17 = btng[16];int arr18 = btng[17];int arr19 = btng[18];int arr20 = btng[19];int arr21 = btng[20];
                        int arr22 = btng[21];int arr23 = btng[22];int arr24 = btng[23];int arr25 = btng[24];int arr26 = btng[25];int arr27 = btng[26];int arr28 = btng[27];
                        int arr29 = btng[28];int arr30 = btng[29];int arr31 = btng[30];int arr32 = btng[31];int arr33 = btng[32];int arr34 = btng[33];int arr35 = btng[34];

                        dbHelper.insert(11, 1, arr1, arr2, arr3, arr4, arr5, arr6, arr7, arr8, arr9, arr10, arr11, arr12, arr13, arr14, arr15, arr16, arr17, arr18, arr19, arr20, arr21
                                , arr22, arr23, arr24, arr25, arr26, arr27, arr28, arr29, arr30, arr31, arr32, arr33, arr34, arr35);
                        dbHelper.searchGroup1();

                        for(int i=0; i<35; i++){
                            if(dbgroup1[i+1] ==1){
                                btngg[i].setBackgroundResource(R.drawable.buttonforgroupinactive); //선택된 애들만 회색화면으로 변경
                                btng[i]=0;
                            }
                            btngg[i].setEnabled(false);
                        }
                        //그룹 설정하고 컨트롤 부분을 초기화 시키는 부분 !
                        groupControl[0] = 0;
                        Group1.setBackgroundResource(R.drawable.smbutton);
                        Toast.makeText(MainActivity.this, "1번 그룹 설정", Toast.LENGTH_SHORT).show();
                    } else{
                        Toast.makeText(MainActivity.this, "그룹을 설정해 주세요", Toast.LENGTH_SHORT).show();
                    }
                }
                if (group[1] == 1) {
                    if(btng[0]+btng[1]+btng[2]+btng[3]+btng[4]+btng[5]+btng[6]+btng[7]+btng[8]+btng[9]+btng[10]+btng[11]+btng[12]+btng[13]+
                            btng[14]+btng[15]+btng[16]+btng[17]+btng[18]+btng[19]+btng[20]+btng[21]+btng[22]+btng[23]+btng[24]+btng[25]+btng[26]+btng[27]+
                            btng[28]+btng[29]+btng[30]+btng[31]+btng[32]+btng[33]+btng[34] != 0){
                        int arr1 = btng[0];int arr2 = btng[1];int arr3 = btng[2];int arr4 = btng[3];int arr5 = btng[4];int arr6 = btng[5];int arr7 = btng[6];
                        int arr8 = btng[7];int arr9 = btng[8];int arr10 = btng[9];int arr11 = btng[10];int arr12 = btng[11];int arr13 = btng[12];int arr14 = btng[13];
                        int arr15 = btng[14];int arr16 = btng[15];int arr17 = btng[16];int arr18 = btng[17];int arr19 = btng[18];int arr20 = btng[19];int arr21 = btng[20];
                        int arr22 = btng[21];int arr23 = btng[22];int arr24 = btng[23];int arr25 = btng[24];int arr26 = btng[25];int arr27 = btng[26];int arr28 = btng[27];
                        int arr29 = btng[28];int arr30 = btng[29];int arr31 = btng[30];int arr32 = btng[31];int arr33 = btng[32];int arr34 = btng[33];int arr35 = btng[34];
                        dbHelper.insert(22, 1, arr1, arr2, arr3, arr4, arr5, arr6, arr7, arr8, arr9, arr10, arr11, arr12, arr13, arr14, arr15, arr16, arr17, arr18, arr19, arr20, arr21
                                , arr22, arr23, arr24, arr25, arr26, arr27, arr28, arr29, arr30, arr31, arr32, arr33, arr34, arr35);
                        dbHelper.searchGroup2();

                        for(int i=0; i<35; i++){
                            if(dbgroup2[i+1] ==1){
                                btngg[i].setBackgroundResource(R.drawable.buttonforgroupinactive);
                                btng[i]=0;
                            }
                            btngg[i].setEnabled(false);
                        }
                        //그룹 설정하고 컨트롤 부분을 초기화 시키는 부분 !
                        groupControl[1] = 0;
                        Group2.setBackgroundResource(R.drawable.smbutton);
                        Toast.makeText(MainActivity.this, "2번 그룹 설정", Toast.LENGTH_SHORT).show();
                    } else{
                        Toast.makeText(MainActivity.this, "그룹을 설정해 주세요", Toast.LENGTH_SHORT).show();
                    }
                }
                if (group[2] == 1) {
                    if(btng[0]+btng[1]+btng[2]+btng[3]+btng[4]+btng[5]+btng[6]+btng[7]+btng[8]+btng[9]+btng[10]+btng[11]+btng[12]+btng[13]+
                            btng[14]+btng[15]+btng[16]+btng[17]+btng[18]+btng[19]+btng[20]+btng[21]+btng[22]+btng[23]+btng[24]+btng[25]+btng[26]+btng[27]+
                            btng[28]+btng[29]+btng[30]+btng[31]+btng[32]+btng[33]+btng[34] != 0){
                        int arr1 = btng[0];int arr2 = btng[1];int arr3 = btng[2];int arr4 = btng[3];int arr5 = btng[4];int arr6 = btng[5];int arr7 = btng[6];
                        int arr8 = btng[7];int arr9 = btng[8];int arr10 = btng[9];int arr11 = btng[10];int arr12 = btng[11];int arr13 = btng[12];int arr14 = btng[13];
                        int arr15 = btng[14];int arr16 = btng[15];int arr17 = btng[16];int arr18 = btng[17];int arr19 = btng[18];int arr20 = btng[19];int arr21 = btng[20];
                        int arr22 = btng[21];int arr23 = btng[22];int arr24 = btng[23];int arr25 = btng[24];int arr26 = btng[25];int arr27 = btng[26];int arr28 = btng[27];
                        int arr29 = btng[28];int arr30 = btng[29];int arr31 = btng[30];int arr32 = btng[31];int arr33 = btng[32];int arr34 = btng[33];int arr35 = btng[34];
                        dbHelper.insert(33, 1, arr1, arr2, arr3, arr4, arr5, arr6, arr7, arr8, arr9, arr10, arr11, arr12, arr13, arr14, arr15, arr16, arr17, arr18, arr19, arr20, arr21
                                , arr22, arr23, arr24, arr25, arr26, arr27, arr28, arr29, arr30, arr31, arr32, arr33, arr34, arr35);
                        dbHelper.searchGroup3();

                        for(int i=0; i<35; i++){
                            if(dbgroup3[i+1] ==1){
                                btngg[i].setBackgroundResource(R.drawable.buttonforgroupinactive);
                                btng[i]=0;
                            }
                            btngg[i].setEnabled(false);
                        }
                        //그룹 설정하고 컨트롤 부분을 초기화 시키는 부분 !
                        groupControl[2] = 0;
                        Group3.setBackgroundResource(R.drawable.smbutton);
                        Toast.makeText(MainActivity.this, "3번 그룹 설정", Toast.LENGTH_SHORT).show();
                    } else{
                        Toast.makeText(MainActivity.this, "그룹을 설정해 주세요", Toast.LENGTH_SHORT).show();
                    }
                }
                if (group[3] == 1) {
                    if(btng[0]+btng[1]+btng[2]+btng[3]+btng[4]+btng[5]+btng[6]+btng[7]+btng[8]+btng[9]+btng[10]+btng[11]+btng[12]+btng[13]+
                            btng[14]+btng[15]+btng[16]+btng[17]+btng[18]+btng[19]+btng[20]+btng[21]+btng[22]+btng[23]+btng[24]+btng[25]+btng[26]+btng[27]+
                            btng[28]+btng[29]+btng[30]+btng[31]+btng[32]+btng[33]+btng[34] != 0){
                        int arr1 = btng[0];int arr2 = btng[1];int arr3 = btng[2];int arr4 = btng[3];int arr5 = btng[4];int arr6 = btng[5];int arr7 = btng[6];
                        int arr8 = btng[7];int arr9 = btng[8];int arr10 = btng[9];int arr11 = btng[10];int arr12 = btng[11];int arr13 = btng[12];int arr14 = btng[13];
                        int arr15 = btng[14];int arr16 = btng[15];int arr17 = btng[16];int arr18 = btng[17];int arr19 = btng[18];int arr20 = btng[19];int arr21 = btng[20];
                        int arr22 = btng[21];int arr23 = btng[22];int arr24 = btng[23];int arr25 = btng[24];int arr26 = btng[25];int arr27 = btng[26];int arr28 = btng[27];
                        int arr29 = btng[28];int arr30 = btng[29];int arr31 = btng[30];int arr32 = btng[31];int arr33 = btng[32];int arr34 = btng[33];int arr35 = btng[34];
                        dbHelper.insert(44, 1, arr1, arr2, arr3, arr4, arr5, arr6, arr7, arr8, arr9, arr10, arr11, arr12, arr13, arr14, arr15, arr16, arr17, arr18, arr19, arr20, arr21
                                , arr22, arr23, arr24, arr25, arr26, arr27, arr28, arr29, arr30, arr31, arr32, arr33, arr34, arr35);
                        dbHelper.searchGroup4();

                        for(int i=0; i<35; i++){
                            if(dbgroup4[i+1] ==1){
                                btngg[i].setBackgroundResource(R.drawable.buttonforgroupinactive);
                                btng[i]=0;
                            }
                            btngg[i].setEnabled(false);
                        }
                        //그룹 설정하고 컨트롤 부분을 초기화 시키는 부분 !
                        groupControl[3] = 0;
                        Group4.setBackgroundResource(R.drawable.smbutton);
                        Toast.makeText(MainActivity.this, "4번 그룹 설정", Toast.LENGTH_SHORT).show();
                    } else{
                        Toast.makeText(MainActivity.this, "그룹을 설정해 주세요", Toast.LENGTH_SHORT).show();
                    }
                }
                if (group[4] == 1) {
                    if(btng[0]+btng[1]+btng[2]+btng[3]+btng[4]+btng[5]+btng[6]+btng[7]+btng[8]+btng[9]+btng[10]+btng[11]+btng[12]+btng[13]+
                            btng[14]+btng[15]+btng[16]+btng[17]+btng[18]+btng[19]+btng[20]+btng[21]+btng[22]+btng[23]+btng[24]+btng[25]+btng[26]+btng[27]+
                            btng[28]+btng[29]+btng[30]+btng[31]+btng[32]+btng[33]+btng[34] != 0){
                        int arr1 = btng[0];int arr2 = btng[1];int arr3 = btng[2];int arr4 = btng[3];int arr5 = btng[4];int arr6 = btng[5];int arr7 = btng[6];
                        int arr8 = btng[7];int arr9 = btng[8];int arr10 = btng[9];int arr11 = btng[10];int arr12 = btng[11];int arr13 = btng[12];int arr14 = btng[13];
                        int arr15 = btng[14];int arr16 = btng[15];int arr17 = btng[16];int arr18 = btng[17];int arr19 = btng[18];int arr20 = btng[19];int arr21 = btng[20];
                        int arr22 = btng[21];int arr23 = btng[22];int arr24 = btng[23];int arr25 = btng[24];int arr26 = btng[25];int arr27 = btng[26];int arr28 = btng[27];
                        int arr29 = btng[28];int arr30 = btng[29];int arr31 = btng[30];int arr32 = btng[31];int arr33 = btng[32];int arr34 = btng[33];int arr35 = btng[34];
                        dbHelper.insert(55, 1, arr1, arr2, arr3, arr4, arr5, arr6, arr7, arr8, arr9, arr10, arr11, arr12, arr13, arr14, arr15, arr16, arr17, arr18, arr19, arr20, arr21
                                , arr22, arr23, arr24, arr25, arr26, arr27, arr28, arr29, arr30, arr31, arr32, arr33, arr34, arr35);
                        dbHelper.searchGroup5();

                        for(int i=0; i<35; i++){
                            if(dbgroup5[i+1] ==1){
                                btngg[i].setBackgroundResource(R.drawable.buttonforgroupinactive);
                                btng[i]=0;
                            }
                            btngg[i].setEnabled(false);
                        }
                        //그룹 설정하고 컨트롤 부분을 초기화 시키는 부분 !
                        groupControl[4] = 0;
                        Group5.setBackgroundResource(R.drawable.smbutton);
                        Toast.makeText(MainActivity.this, "5번 그룹 설정", Toast.LENGTH_SHORT).show();
                    } else{
                        Toast.makeText(MainActivity.this, "그룹을 설정해 주세요", Toast.LENGTH_SHORT).show();
                    }
                }
                if (group[5] == 1) {
                    if(btng[0]+btng[1]+btng[2]+btng[3]+btng[4]+btng[5]+btng[6]+btng[7]+btng[8]+btng[9]+btng[10]+btng[11]+btng[12]+btng[13]+
                            btng[14]+btng[15]+btng[16]+btng[17]+btng[18]+btng[19]+btng[20]+btng[21]+btng[22]+btng[23]+btng[24]+btng[25]+btng[26]+btng[27]+
                            btng[28]+btng[29]+btng[30]+btng[31]+btng[32]+btng[33]+btng[34] != 0){
                        int arr1 = btng[0];int arr2 = btng[1];int arr3 = btng[2];int arr4 = btng[3];int arr5 = btng[4];int arr6 = btng[5];int arr7 = btng[6];
                        int arr8 = btng[7];int arr9 = btng[8];int arr10 = btng[9];int arr11 = btng[10];int arr12 = btng[11];int arr13 = btng[12];int arr14 = btng[13];
                        int arr15 = btng[14];int arr16 = btng[15];int arr17 = btng[16];int arr18 = btng[17];int arr19 = btng[18];int arr20 = btng[19];int arr21 = btng[20];
                        int arr22 = btng[21];int arr23 = btng[22];int arr24 = btng[23];int arr25 = btng[24];int arr26 = btng[25];int arr27 = btng[26];int arr28 = btng[27];
                        int arr29 = btng[28];int arr30 = btng[29];int arr31 = btng[30];int arr32 = btng[31];int arr33 = btng[32];int arr34 = btng[33];int arr35 = btng[34];
                        dbHelper.insert(66, 1, arr1, arr2, arr3, arr4, arr5, arr6, arr7, arr8, arr9, arr10, arr11, arr12, arr13, arr14, arr15, arr16, arr17, arr18, arr19, arr20, arr21
                                , arr22, arr23, arr24, arr25, arr26, arr27, arr28, arr29, arr30, arr31, arr32, arr33, arr34, arr35);
                        dbHelper.searchGroup6();

                        for(int i=0; i<35; i++){
                            if(dbgroup6[i+1] ==1){
                                btngg[i].setBackgroundResource(R.drawable.buttonforgroupinactive);
                                btng[i]=0;
                            }
                            btngg[i].setEnabled(false);
                        }
                        //그룹 설정하고 컨트롤 부분을 초기화 시키는 부분 !
                        groupControl[5] = 0;
                        Group6.setBackgroundResource(R.drawable.smbutton);
                        Toast.makeText(MainActivity.this, "6번 그룹 설정", Toast.LENGTH_SHORT).show();
                    } else{
                        Toast.makeText(MainActivity.this, "그룹을 설정해 주세요", Toast.LENGTH_SHORT).show();
                    }
                }
                if (group[6] == 1) {
                    if(btng[0]+btng[1]+btng[2]+btng[3]+btng[4]+btng[5]+btng[6]+btng[7]+btng[8]+btng[9]+btng[10]+btng[11]+btng[12]+btng[13]+
                            btng[14]+btng[15]+btng[16]+btng[17]+btng[18]+btng[19]+btng[20]+btng[21]+btng[22]+btng[23]+btng[24]+btng[25]+btng[26]+btng[27]+
                            btng[28]+btng[29]+btng[30]+btng[31]+btng[32]+btng[33]+btng[34] != 0){
                        int arr1 = btng[0];int arr2 = btng[1];int arr3 = btng[2];int arr4 = btng[3];int arr5 = btng[4];int arr6 = btng[5];int arr7 = btng[6];
                        int arr8 = btng[7];int arr9 = btng[8];int arr10 = btng[9];int arr11 = btng[10];int arr12 = btng[11];int arr13 = btng[12];int arr14 = btng[13];
                        int arr15 = btng[14];int arr16 = btng[15];int arr17 = btng[16];int arr18 = btng[17];int arr19 = btng[18];int arr20 = btng[19];int arr21 = btng[20];
                        int arr22 = btng[21];int arr23 = btng[22];int arr24 = btng[23];int arr25 = btng[24];int arr26 = btng[25];int arr27 = btng[26];int arr28 = btng[27];
                        int arr29 = btng[28];int arr30 = btng[29];int arr31 = btng[30];int arr32 = btng[31];int arr33 = btng[32];int arr34 = btng[33];int arr35 = btng[34];
                        dbHelper.insert(77, 1, arr1, arr2, arr3, arr4, arr5, arr6, arr7, arr8, arr9, arr10, arr11, arr12, arr13, arr14, arr15, arr16, arr17, arr18, arr19, arr20, arr21
                                , arr22, arr23, arr24, arr25, arr26, arr27, arr28, arr29, arr30, arr31, arr32, arr33, arr34, arr35);
                        dbHelper.searchGroup7();

                        for(int i=0; i<35; i++){
                            if(dbgroup7[i+1] ==1){
                                btngg[i].setBackgroundResource(R.drawable.buttonforgroupinactive);
                                btng[i]=0;
                            }
                            btngg[i].setEnabled(false);
                        }
                        //그룹 설정하고 컨트롤 부분을 초기화 시키는 부분 !
                        groupControl[6] = 0;
                        Group6.setBackgroundResource(R.drawable.smbutton);
                        Toast.makeText(MainActivity.this, "7번 그룹 설정", Toast.LENGTH_SHORT).show();
                    } else{
                        Toast.makeText(MainActivity.this, "그룹을 설정해 주세요", Toast.LENGTH_SHORT).show();
                    }
                }
                if (group[7] == 1) {
                    if(btng[0]+btng[1]+btng[2]+btng[3]+btng[4]+btng[5]+btng[6]+btng[7]+btng[8]+btng[9]+btng[10]+btng[11]+btng[12]+btng[13]+
                            btng[14]+btng[15]+btng[16]+btng[17]+btng[18]+btng[19]+btng[20]+btng[21]+btng[22]+btng[23]+btng[24]+btng[25]+btng[26]+btng[27]+
                            btng[28]+btng[29]+btng[30]+btng[31]+btng[32]+btng[33]+btng[34] != 0){
                        int arr1 = btng[0];int arr2 = btng[1];int arr3 = btng[2];int arr4 = btng[3];int arr5 = btng[4];int arr6 = btng[5];int arr7 = btng[6];
                        int arr8 = btng[7];int arr9 = btng[8];int arr10 = btng[9];int arr11 = btng[10];int arr12 = btng[11];int arr13 = btng[12];int arr14 = btng[13];
                        int arr15 = btng[14];int arr16 = btng[15];int arr17 = btng[16];int arr18 = btng[17];int arr19 = btng[18];int arr20 = btng[19];int arr21 = btng[20];
                        int arr22 = btng[21];int arr23 = btng[22];int arr24 = btng[23];int arr25 = btng[24];int arr26 = btng[25];int arr27 = btng[26];int arr28 = btng[27];
                        int arr29 = btng[28];int arr30 = btng[29];int arr31 = btng[30];int arr32 = btng[31];int arr33 = btng[32];int arr34 = btng[33];int arr35 = btng[34];
                        dbHelper.insert(88, 1, arr1, arr2, arr3, arr4, arr5, arr6, arr7, arr8, arr9, arr10, arr11, arr12, arr13, arr14, arr15, arr16, arr17, arr18, arr19, arr20, arr21
                                , arr22, arr23, arr24, arr25, arr26, arr27, arr28, arr29, arr30, arr31, arr32, arr33, arr34, arr35);
                        dbHelper.searchGroup8();

                        for(int i=0; i<35; i++){
                            if(dbgroup8[i+1] ==1){
                                btngg[i].setBackgroundResource(R.drawable.buttonforgroupinactive);
                                btng[i]=0;
                            }
                            btngg[i].setEnabled(false);
                        }
                        //그룹 설정하고 컨트롤 부분을 초기화 시키는 부분 !
                        groupControl[7] = 0;
                        Group6.setBackgroundResource(R.drawable.smbutton);
                        Toast.makeText(MainActivity.this, "8번 그룹 설정", Toast.LENGTH_SHORT).show();
                    } else{
                        Toast.makeText(MainActivity.this, "그룹을 설정해 주세요", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        Button Reset = (Button) findViewById(R.id.Reset);
        //그룹모드에서 초기화!
        Reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (group[0] == 1){
                    //한그룹을 초기화 시키면 나머지도 다 off 되기 때문에 그에 맞게 arraySizeforgroup을 맞춰야함
                    arraySizeforgroup=0;
                    dbHelper.delete(11);
                    dbHelper.searchGroup2();
                    dbHelper.searchGroup3();
                    dbHelper.searchGroup4();
                    dbHelper.searchGroup5();
                    dbHelper.searchGroup6();
                    dbHelper.searchGroup7();
                    dbHelper.searchGroup8();
                    for(int i=0; i<35; i++){
                        //그룹모드 초기화 할때 본인에 해당하는것만 지우기위한것
                        if(dbgroup2[i+1] !=1 && dbgroup3[i+1] !=1 && dbgroup4[i+1] !=1 && dbgroup5[i+1] !=1 && dbgroup6[i+1] !=1 && dbgroup7[i+1] !=1
                                && dbgroup8[i+1] !=1){
                            btngg[i].setEnabled(true);
                            btngg[i].setBackgroundResource(R.drawable.buttonforgroupoff);
                        }
                        // 기존의 신호 보내는거 없애기
                        tempforgroup[i] = 0;
                        tempControlforgroup[i] = 0;
                    }
                    groupControl[0] = 0;
                    Group1.setBackgroundResource(R.drawable.smbutton);
                    groupControl[1] = 0;
                    Group2.setBackgroundResource(R.drawable.smbutton);
                    groupControl[2] = 0;
                    Group3.setBackgroundResource(R.drawable.smbutton);
                    groupControl[3] = 0;
                    Group4.setBackgroundResource(R.drawable.smbutton);
                    groupControl[4] = 0;
                    Group5.setBackgroundResource(R.drawable.smbutton);
                    groupControl[5] = 0;
                    Group6.setBackgroundResource(R.drawable.smbutton);
                    groupControl[6] = 0;
                    Group7.setBackgroundResource(R.drawable.smbutton);
                    groupControl[7] = 0;
                    Group8.setBackgroundResource(R.drawable.smbutton);
            }
                if (group[1] == 1){
                    //한그룹을 초기화 시키면 나머지도 다 off 되기 때문에 그에 맞게 arraySizeforgroup을 맞춰야함
                    arraySizeforgroup=0;
                    dbHelper.delete2(22);
                    dbHelper.searchGroup1();
                    dbHelper.searchGroup3();
                    dbHelper.searchGroup4();
                    dbHelper.searchGroup5();
                    dbHelper.searchGroup6();
                    dbHelper.searchGroup7();
                    dbHelper.searchGroup8();
                    for(int i=0; i<35; i++){
                        //그룹모드 초기화 할때 본인에 해당하는것만 지우기위한것
                        if(dbgroup1[i+1] !=1 && dbgroup3[i+1] !=1 && dbgroup4[i+1] !=1 && dbgroup5[i+1] !=1 && dbgroup6[i+1] !=1 && dbgroup7[i+1] !=1
                                && dbgroup8[i+1] !=1){
                            btngg[i].setEnabled(true);
                            btngg[i].setBackgroundResource(R.drawable.buttonforgroupoff);
                        }

                        // 기존의 신호 보내는거 없애기
                        tempforgroup[i] = 0;
                        tempControlforgroup[i] = 0;
                    }
                    groupControl[0] = 0;
                    Group1.setBackgroundResource(R.drawable.smbutton);
                    groupControl[1] = 0;
                    Group2.setBackgroundResource(R.drawable.smbutton);
                    groupControl[2] = 0;
                    Group3.setBackgroundResource(R.drawable.smbutton);
                    groupControl[3] = 0;
                    Group4.setBackgroundResource(R.drawable.smbutton);
                    groupControl[4] = 0;
                    Group5.setBackgroundResource(R.drawable.smbutton);
                    groupControl[5] = 0;
                    Group6.setBackgroundResource(R.drawable.smbutton);
                    groupControl[6] = 0;
                    Group7.setBackgroundResource(R.drawable.smbutton);
                    groupControl[7] = 0;
                    Group8.setBackgroundResource(R.drawable.smbutton);
                }
                if (group[2] == 1){
                    //한그룹을 초기화 시키면 나머지도 다 off 되기 때문에 그에 맞게 arraySizeforgroup을 맞춰야함
                    arraySizeforgroup=0;
                    dbHelper.delete3(33);
                    dbHelper.searchGroup1();
                    dbHelper.searchGroup2();
                    dbHelper.searchGroup4();
                    dbHelper.searchGroup5();
                    dbHelper.searchGroup6();
                    dbHelper.searchGroup7();
                    dbHelper.searchGroup8();
                    for(int i=0; i<35; i++){
                        //그룹모드 초기화 할때 본인에 해당하는것만 지우기위한것
                        if(dbgroup1[i+1] !=1 && dbgroup2[i+1] !=1  && dbgroup4[i+1] !=1 && dbgroup5[i+1] !=1 && dbgroup6[i+1] !=1 && dbgroup7[i+1] !=1
                                && dbgroup8[i+1] !=1){
                            btngg[i].setEnabled(true);
                            btngg[i].setBackgroundResource(R.drawable.buttonforgroupoff);
                        }

                        // 기존의 신호 보내는거 없애기
                        tempforgroup[i] = 0;
                        tempControlforgroup[i] = 0;
                    }
                    groupControl[0] = 0;
                    Group1.setBackgroundResource(R.drawable.smbutton);
                    groupControl[1] = 0;
                    Group2.setBackgroundResource(R.drawable.smbutton);
                    groupControl[2] = 0;
                    Group3.setBackgroundResource(R.drawable.smbutton);
                    groupControl[3] = 0;
                    Group4.setBackgroundResource(R.drawable.smbutton);
                    groupControl[4] = 0;
                    Group5.setBackgroundResource(R.drawable.smbutton);
                    groupControl[5] = 0;
                    Group6.setBackgroundResource(R.drawable.smbutton);
                    groupControl[6] = 0;
                    Group7.setBackgroundResource(R.drawable.smbutton);
                    groupControl[7] = 0;
                    Group8.setBackgroundResource(R.drawable.smbutton);
                }
                if (group[3] == 1){
                    //한그룹을 초기화 시키면 나머지도 다 off 되기 때문에 그에 맞게 arraySizeforgroup을 맞춰야함
                    arraySizeforgroup=0;
                    dbHelper.delete4(44);
                    dbHelper.searchGroup1();
                    dbHelper.searchGroup2();
                    dbHelper.searchGroup3();
                    dbHelper.searchGroup5();
                    dbHelper.searchGroup6();
                    dbHelper.searchGroup7();
                    dbHelper.searchGroup8();
                    for(int i=0; i<35; i++){
                        //그룹모드 초기화 할때 본인에 해당하는것만 지우기위한것
                        if(dbgroup1[i+1] !=1 && dbgroup2[i+1] !=1 && dbgroup3[i+1] !=1 && dbgroup5[i+1] !=1 && dbgroup6[i+1] !=1 && dbgroup7[i+1] !=1
                                && dbgroup8[i+1] !=1){
                            btngg[i].setEnabled(true);
                            btngg[i].setBackgroundResource(R.drawable.buttonforgroupoff);
                        }

                        // 기존의 신호 보내는거 없애기
                        tempforgroup[i] = 0;
                        tempControlforgroup[i] = 0;
                    }
                    groupControl[0] = 0;
                    Group1.setBackgroundResource(R.drawable.smbutton);
                    groupControl[1] = 0;
                    Group2.setBackgroundResource(R.drawable.smbutton);
                    groupControl[2] = 0;
                    Group3.setBackgroundResource(R.drawable.smbutton);
                    groupControl[3] = 0;
                    Group4.setBackgroundResource(R.drawable.smbutton);
                    groupControl[4] = 0;
                    Group5.setBackgroundResource(R.drawable.smbutton);
                    groupControl[5] = 0;
                    Group6.setBackgroundResource(R.drawable.smbutton);
                    groupControl[6] = 0;
                    Group7.setBackgroundResource(R.drawable.smbutton);
                    groupControl[7] = 0;
                    Group8.setBackgroundResource(R.drawable.smbutton);
                }
                if (group[4] == 1){
                    //한그룹을 초기화 시키면 나머지도 다 off 되기 때문에 그에 맞게 arraySizeforgroup을 맞춰야함
                    arraySizeforgroup=0;
                    dbHelper.delete5(55);
                    dbHelper.searchGroup1();
                    dbHelper.searchGroup2();
                    dbHelper.searchGroup3();
                    dbHelper.searchGroup4();
                    dbHelper.searchGroup6();
                    dbHelper.searchGroup7();
                    dbHelper.searchGroup8();
                    for(int i=0; i<35; i++){
                        //그룹모드 초기화 할때 본인에 해당하는것만 지우기위한것
                        if(dbgroup1[i+1] !=1 && dbgroup2[i+1] !=1 && dbgroup3[i+1] !=1 && dbgroup4[i+1] !=1 && dbgroup6[i+1] !=1 && dbgroup7[i+1] !=1
                                && dbgroup8[i+1] !=1){
                            btngg[i].setEnabled(true);
                            btngg[i].setBackgroundResource(R.drawable.buttonforgroupoff);
                        }

                        // 기존의 신호 보내는거 없애기
                        tempforgroup[i] = 0;
                        tempControlforgroup[i] = 0;
                    }
                    groupControl[0] = 0;
                    Group1.setBackgroundResource(R.drawable.smbutton);
                    groupControl[1] = 0;
                    Group2.setBackgroundResource(R.drawable.smbutton);
                    groupControl[2] = 0;
                    Group3.setBackgroundResource(R.drawable.smbutton);
                    groupControl[3] = 0;
                    Group4.setBackgroundResource(R.drawable.smbutton);
                    groupControl[4] = 0;
                    Group5.setBackgroundResource(R.drawable.smbutton);
                    groupControl[5] = 0;
                    Group6.setBackgroundResource(R.drawable.smbutton);
                    groupControl[6] = 0;
                    Group7.setBackgroundResource(R.drawable.smbutton);
                    groupControl[7] = 0;
                    Group8.setBackgroundResource(R.drawable.smbutton);
                }
                if (group[5] == 1){
                    //한그룹을 초기화 시키면 나머지도 다 off 되기 때문에 그에 맞게 arraySizeforgroup을 맞춰야함
                    arraySizeforgroup=0;
                    dbHelper.delete6(66);
                    dbHelper.searchGroup1();
                    dbHelper.searchGroup2();
                    dbHelper.searchGroup3();
                    dbHelper.searchGroup4();
                    dbHelper.searchGroup5();
                    dbHelper.searchGroup7();
                    dbHelper.searchGroup8();
                    for(int i=0; i<35; i++){
                        //그룹모드 초기화 할때 본인에 해당하는것만 지우기위한것
                        if(dbgroup1[i+1] !=1 && dbgroup2[i+1] !=1 && dbgroup3[i+1] !=1 && dbgroup4[i+1] !=1 && dbgroup5[i+1] !=1 && dbgroup7[i+1] !=1
                                && dbgroup8[i+1] !=1){
                            btngg[i].setEnabled(true);
                            btngg[i].setBackgroundResource(R.drawable.buttonforgroupoff);
                        }

                        // 기존의 신호 보내는거 없애기
                        tempforgroup[i] = 0;
                        tempControlforgroup[i] = 0;
                    }
                    groupControl[0] = 0;
                    Group1.setBackgroundResource(R.drawable.smbutton);
                    groupControl[1] = 0;
                    Group2.setBackgroundResource(R.drawable.smbutton);
                    groupControl[2] = 0;
                    Group3.setBackgroundResource(R.drawable.smbutton);
                    groupControl[3] = 0;
                    Group4.setBackgroundResource(R.drawable.smbutton);
                    groupControl[4] = 0;
                    Group5.setBackgroundResource(R.drawable.smbutton);
                    groupControl[5] = 0;
                    Group6.setBackgroundResource(R.drawable.smbutton);
                    groupControl[6] = 0;
                    Group7.setBackgroundResource(R.drawable.smbutton);
                    groupControl[7] = 0;
                    Group8.setBackgroundResource(R.drawable.smbutton);
                }
                if (group[6] == 1){
                    //한그룹을 초기화 시키면 나머지도 다 off 되기 때문에 그에 맞게 arraySizeforgroup을 맞춰야함
                    arraySizeforgroup=0;
                    dbHelper.delete7(77);
                    dbHelper.searchGroup1();
                    dbHelper.searchGroup2();
                    dbHelper.searchGroup3();
                    dbHelper.searchGroup4();
                    dbHelper.searchGroup5();
                    dbHelper.searchGroup6();
                    dbHelper.searchGroup8();
                    for(int i=0; i<35; i++){
                        //그룹모드 초기화 할때 본인에 해당하는것만 지우기위한것
                        if(dbgroup1[i+1] !=1 && dbgroup2[i+1] !=1 && dbgroup3[i+1] !=1 && dbgroup4[i+1] !=1 && dbgroup5[i+1] !=1 && dbgroup6[i+1] !=1 && dbgroup8[i+1] !=1){
                            btngg[i].setEnabled(true);
                            btngg[i].setBackgroundResource(R.drawable.buttonforgroupoff);
                        }

                        // 기존의 신호 보내는거 없애기
                        tempforgroup[i] = 0;
                        tempControlforgroup[i] = 0;
                    }
                    groupControl[0] = 0;
                    Group1.setBackgroundResource(R.drawable.smbutton);
                    groupControl[1] = 0;
                    Group2.setBackgroundResource(R.drawable.smbutton);
                    groupControl[2] = 0;
                    Group3.setBackgroundResource(R.drawable.smbutton);
                    groupControl[3] = 0;
                    Group4.setBackgroundResource(R.drawable.smbutton);
                    groupControl[4] = 0;
                    Group5.setBackgroundResource(R.drawable.smbutton);
                    groupControl[5] = 0;
                    Group6.setBackgroundResource(R.drawable.smbutton);
                    groupControl[6] = 0;
                    Group7.setBackgroundResource(R.drawable.smbutton);
                    groupControl[7] = 0;
                    Group8.setBackgroundResource(R.drawable.smbutton);
                }
                if (group[7] == 1){
                    //한그룹을 초기화 시키면 나머지도 다 off 되기 때문에 그에 맞게 arraySizeforgroup을 맞춰야함
                    arraySizeforgroup=0;
                    dbHelper.delete8(88);
                    dbHelper.searchGroup1();
                    dbHelper.searchGroup2();
                    dbHelper.searchGroup3();
                    dbHelper.searchGroup4();
                    dbHelper.searchGroup5();
                    dbHelper.searchGroup6();
                    dbHelper.searchGroup7();
                    for(int i=0; i<35; i++){
                        //그룹모드 초기화 할때 본인에 해당하는것만 지우기위한것
                        if(dbgroup1[i+1] !=1 && dbgroup2[i+1] !=1 && dbgroup3[i+1] !=1 && dbgroup4[i+1] !=1 && dbgroup5[i+1] !=1 && dbgroup6[i+1] !=1 && dbgroup7[i+1] !=1){
                            btngg[i].setEnabled(true);
                            btngg[i].setBackgroundResource(R.drawable.buttonforgroupoff);
                        }

                        // 기존의 신호 보내는거 없애기
                        tempforgroup[i] = 0;
                        tempControlforgroup[i] = 0;
                    }
                    groupControl[0] = 0;
                    Group1.setBackgroundResource(R.drawable.smbutton);
                    groupControl[1] = 0;
                    Group2.setBackgroundResource(R.drawable.smbutton);
                    groupControl[2] = 0;
                    Group3.setBackgroundResource(R.drawable.smbutton);
                    groupControl[3] = 0;
                    Group4.setBackgroundResource(R.drawable.smbutton);
                    groupControl[4] = 0;
                    Group5.setBackgroundResource(R.drawable.smbutton);
                    groupControl[5] = 0;
                    Group6.setBackgroundResource(R.drawable.smbutton);
                    groupControl[6] = 0;
                    Group7.setBackgroundResource(R.drawable.smbutton);
                    groupControl[7] = 0;
                    Group8.setBackgroundResource(R.drawable.smbutton);
                }
        }
    });

    ImageButton Setting = (ImageButton) findViewById(R.id.Setting);
    Setting.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            option1.setVisibility(View.GONE);
            option2.setVisibility(View.GONE);
            option3.setVisibility(View.VISIBLE);
            option4.setVisibility(View.GONE);
            barForLight.setVisibility(View.GONE);
            barForUpdown.setVisibility(View.GONE);
            barForGroup.setVisibility(View.VISIBLE);
            nameForgroup.setVisibility(View.GONE);
            nameForgroup2.setVisibility(View.VISIBLE);
            nameForgroup3.setVisibility(View.VISIBLE);
            main.setVisibility(View.GONE);
                main2.setVisibility(View.GONE);
                main3.setVisibility(View.GONE);
                main4.setVisibility(View.GONE);
                main5.setVisibility(View.GONE);
                main6.setVisibility(View.GONE);
                main7.setVisibility(View.GONE);
                main8.setVisibility(View.GONE);
                SetGroup.setVisibility(View.VISIBLE);
                SetGroupButton.setVisibility(View.VISIBLE);
                SetGroupButton2.setVisibility(View.VISIBLE);
                SetGroupButton3.setVisibility(View.VISIBLE);
                SetGroupButton4.setVisibility(View.VISIBLE);
                SetGroupButton5.setVisibility(View.VISIBLE);
                All.setVisibility(View.GONE);
                dbHelper.searchGroup1();
                dbHelper.searchGroup2();
                dbHelper.searchGroup3();
                dbHelper.searchGroup4();
                dbHelper.searchGroup5();
                dbHelper.searchGroup6();
                dbHelper.searchGroup7();
                dbHelper.searchGroup8();

                for(int i=0; i<35; i++){
                    if(dbgroup1[i+1] == 1 || dbgroup2[i+1] == 1 || dbgroup3[i+1] == 1 || dbgroup4[i+1] == 1 || dbgroup5[i+1] == 1 || dbgroup6[i+1] == 1 ||
                            dbgroup7[i+1] == 1 || dbgroup8[i+1] == 1){
                        btngg[i].setBackgroundResource(R.drawable.buttonforgroupinactive);
                        btngg[i].setEnabled(false);
                    }
                }
            }
        });
        // BACK 버튼
        Button Back = (Button) findViewById(R.id.Back);
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                option1.setVisibility(View.GONE);
                option2.setVisibility(View.GONE);
                option3.setVisibility(View.GONE);
                option4.setVisibility(View.GONE);
                barForGroup.setVisibility(View.GONE);
                main.setVisibility(View.VISIBLE);
                main2.setVisibility(View.VISIBLE);
                main3.setVisibility(View.VISIBLE);
                main4.setVisibility(View.VISIBLE);
                main5.setVisibility(View.VISIBLE);
                main6.setVisibility(View.VISIBLE);
                main7.setVisibility(View.VISIBLE);
                main8.setVisibility(View.VISIBLE);
                SetGroup.setVisibility(View.GONE);
                SetGroupButton.setVisibility(View.GONE);
                SetGroupButton2.setVisibility(View.GONE);
                SetGroupButton3.setVisibility(View.GONE);
                SetGroupButton4.setVisibility(View.GONE);
                SetGroupButton5.setVisibility(View.GONE);
                nameForgroup2.setVisibility(View.GONE);
                nameForgroup3.setVisibility(View.GONE);
                All.setVisibility(View.VISIBLE);
                nameForgroup.setVisibility(View.VISIBLE);
                lampButton.setBackgroundResource(R.drawable.lightgreen);
                upDownButton.setBackgroundResource(R.drawable.updowngreen);



            }
        });

        // 컨트롤모드에서의 그룹입니다.
        Button Group1con = (Button) findViewById(R.id.Group1);
        Group1con.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkLightState();
                if (groupControl[0] == 0) {
                    groupControl[0] = 1;
                    dbHelper.searchGroup1();
                    Group1.setBackgroundResource(R.drawable.groupbutton);
                    for (int i = 0; i < 35; i++) {
                        if (dbgroup1[i+1] == 1) {
                            tempforgroup[i] = (byte) (i + 1);
                            tempControlforgroup[i] = (byte) (i + 1);
                            arraySizeforgroup++;
                        }
                    }

                } else{
                    groupControl[0] = 0;
                    dbHelper.searchGroup1();
                    Group1.setBackgroundResource(R.drawable.smbutton);
                    for (int i = 0; i < 35; i++) {
                        if (dbgroup1[i+1] == 1) {
                            tempforgroup[i] = 0;
                            tempControlforgroup[i] = 0;
                            arraySizeforgroup--;
                        }
                    }
                }
            }
        });
        Button Group2con = (Button) findViewById(R.id.Group2);
        Group2con.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkLightState();
                if (groupControl[1] == 0) {
                    groupControl[1] = 1;
                    dbHelper.searchGroup2();
                    Group2.setBackgroundResource(R.drawable.groupbutton);
                    for (int i = 0; i < 35; i++) {
                        if (dbgroup2[i+1] == 1) {
                            tempforgroup[i] = (byte) (i + 1);
                            tempControlforgroup[i] = (byte) (i + 1);
                            arraySizeforgroup++;
                        }
                    }

                } else{
                    groupControl[1] = 0;
                    dbHelper.searchGroup2();
                    Group2.setBackgroundResource(R.drawable.smbutton);
                    for (int i = 0; i < 35; i++) {
                        if (dbgroup2[i+1] == 1) {
                            tempforgroup[i] = 0;
                            tempControlforgroup[i] = 0;
                            arraySizeforgroup--;
                        }
                    }
                }
            }
        });

        Button Group3con = (Button) findViewById(R.id.Group3);
        Group3con.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkLightState();
                if (groupControl[2] == 0) {
                    groupControl[2] = 1;
                    dbHelper.searchGroup3();
                    Group3.setBackgroundResource(R.drawable.groupbutton);
                    for (int i = 0; i < 35; i++) {
                        if (dbgroup3[i+1] == 1) {
                            tempforgroup[i] = (byte) (i + 1);
                            tempControlforgroup[i] = (byte) (i + 1);
                            arraySizeforgroup++;
                        }
                    }

                } else{
                    groupControl[2] = 0;
                    dbHelper.searchGroup3();
                    Group3.setBackgroundResource(R.drawable.smbutton);
                    for (int i = 0; i < 35; i++) {
                        if (dbgroup3[i+1] == 1) {
                            tempforgroup[i] = 0;
                            tempControlforgroup[i] = 0;
                            arraySizeforgroup--;
                        }
                    }
                }
            }
        });
        Button Group4con = (Button) findViewById(R.id.Group4);
        Group4con.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkLightState();
                if (groupControl[3] == 0) {
                    groupControl[3] = 1;
                    dbHelper.searchGroup4();
                    Group4.setBackgroundResource(R.drawable.groupbutton);
                    for (int i = 0; i < 35; i++) {
                        if (dbgroup4[i+1] == 1) {
                            tempforgroup[i] = (byte) (i + 1);
                            tempControlforgroup[i] = (byte) (i + 1);
                            arraySizeforgroup++;
                        }
                    }

                } else{
                    groupControl[3] = 0;
                    dbHelper.searchGroup4();
                    Group4.setBackgroundResource(R.drawable.smbutton);
                    for (int i = 0; i < 35; i++) {
                        if (dbgroup4[i+1] == 1) {
                            tempforgroup[i] = 0;
                            tempControlforgroup[i] = 0;
                            arraySizeforgroup--;
                        }
                    }
                }
            }
        });
        Button Group5con = (Button) findViewById(R.id.Group5);
        Group5con.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkLightState();
                if (groupControl[4] == 0) {
                    groupControl[4] = 1;
                    dbHelper.searchGroup5();
                    Group5.setBackgroundResource(R.drawable.groupbutton);
                    for (int i = 0; i < 35; i++) {
                        if (dbgroup5[i+1] == 1) {
                            tempforgroup[i] = (byte) (i + 1);
                            tempControlforgroup[i] = (byte) (i + 1);
                            arraySizeforgroup++;
                        }
                    }

                } else{
                    groupControl[4] = 0;
                    dbHelper.searchGroup5();
                    Group5.setBackgroundResource(R.drawable.smbutton);
                    for (int i = 0; i < 35; i++) {
                        if (dbgroup5[i+1] == 1) {
                            tempforgroup[i] = 0;
                            tempControlforgroup[i] = 0;
                            arraySizeforgroup--;
                        }
                    }
                }
            }
        });
        Button Group6con = (Button) findViewById(R.id.Group6);
        Group6con.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkLightState();
                if (groupControl[5] == 0) {
                    groupControl[5] = 1;
                    dbHelper.searchGroup6();
                    Group6.setBackgroundResource(R.drawable.groupbutton);
                    for (int i = 0; i < 35; i++) {
                        if (dbgroup6[i+1] == 1) {
                            tempforgroup[i] = (byte) (i + 1);
                            tempControlforgroup[i] = (byte) (i + 1);
                            arraySizeforgroup++;
                        }
                    }

                } else{
                    groupControl[5] = 0;
                    dbHelper.searchGroup6();
                    Group6.setBackgroundResource(R.drawable.smbutton);
                    for (int i = 0; i < 35; i++) {
                        if (dbgroup6[i+1] == 1) {
                            tempforgroup[i] = 0;
                            tempControlforgroup[i] = 0;
                            arraySizeforgroup--;
                        }
                    }
                }
            }
        });
        Button Group7con = (Button) findViewById(R.id.Group7);
        Group7con.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkLightState();
                if (groupControl[6] == 0) {
                    groupControl[6] = 1;
                    dbHelper.searchGroup7();
                    Group7.setBackgroundResource(R.drawable.groupbutton);
                    for (int i = 0; i < 35; i++) {
                        if (dbgroup7[i+1] == 1) {
                            tempforgroup[i] = (byte) (i + 1);
                            tempControlforgroup[i] = (byte) (i + 1);
                            arraySizeforgroup++;
                        }
                    }

                } else{
                    groupControl[6] = 0;
                    dbHelper.searchGroup7();
                    Group7.setBackgroundResource(R.drawable.smbutton);
                    for (int i = 0; i < 35; i++) {
                        if (dbgroup7[i+1] == 1) {
                            tempforgroup[i] = 0;
                            tempControlforgroup[i] = 0;
                            arraySizeforgroup--;
                        }
                    }
                }
            }
        });
        Button Group8con = (Button) findViewById(R.id.Group8);
        Group8con.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkLightState();
                if (groupControl[7] == 0) {
                    groupControl[7] = 1;
                    dbHelper.searchGroup8();
                    Group8.setBackgroundResource(R.drawable.groupbutton);
                    for (int i = 0; i < 35; i++) {
                        if (dbgroup8[i+1] == 1) {
                            tempforgroup[i] = (byte) (i + 1);
                            tempControlforgroup[i] = (byte) (i + 1);
                            arraySizeforgroup++;
                        }
                    }

                } else{
                    groupControl[7] = 0;
                    dbHelper.searchGroup8();
                    Group8.setBackgroundResource(R.drawable.smbutton);
                    for (int i = 0; i < 35; i++) {
                        if (dbgroup8[i+1] == 1) {
                            tempforgroup[i] = 0;
                            tempControlforgroup[i] = 0;
                            arraySizeforgroup--;
                        }
                    }
                }
            }
        });

        // 그룹모드에서의 그룹입니다.
        // 그룹모드에서의 그룹입니다.
        // 그룹모드에서의 그룹입니다.
        Button Group1Set = (Button) findViewById(R.id.Group1Set);
        Group1Set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (group[0] == 0) {
                    groupSize = 1;
                    resetGroup();
                    btnGroup1Set.setBackgroundResource(R.drawable.groupbutton);
                    group[0] = 1;
                    dbHelper.searchGroup1();
                    dbHelper.searchGroup2();
                    dbHelper.searchGroup3();
                    dbHelper.searchGroup4();
                    dbHelper.searchGroup5();
                    dbHelper.searchGroup6();
                    dbHelper.searchGroup7();
                    dbHelper.searchGroup8();

                    for(int i=0; i<35; i++){
                        if(dbgroup2[i+1] ==1 || dbgroup3[i+1] ==1 || dbgroup4[i+1] ==1 || dbgroup5[i+1] ==1 || dbgroup6[i+1] ==1 || dbgroup7[i+1] ==1
                                || dbgroup8[i+1] ==1){
                            btngg[i].setEnabled(false);
                        }else{
                            btngg[i].setEnabled(true);
                        }
                    }

                    if(dbgroup1[0]==1){ //// 1번 그룹이 존재한다면;;
                        for(int i=0; i<35; i++){
                            btngg[i].setEnabled(false);
                        }
                    }

                }
            }
        });
        Button Group2Set = (Button) findViewById(R.id.Group2Set);
        Group2Set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (group[1] == 0) {
                    groupSize = 1;
                    resetGroup();
                    btnGroup2Set.setBackgroundResource(R.drawable.groupbutton);
                    group[1] = 1;
                    dbHelper.searchGroup1();
                    dbHelper.searchGroup2();
                    dbHelper.searchGroup3();
                    dbHelper.searchGroup4();
                    dbHelper.searchGroup5();
                    dbHelper.searchGroup6();
                    dbHelper.searchGroup7();
                    dbHelper.searchGroup8();

                    for(int i=0; i<35; i++){
                        if(dbgroup1[i+1] ==1 || dbgroup3[i+1] ==1 || dbgroup4[i+1] ==1 || dbgroup5[i+1] ==1 || dbgroup6[i+1] ==1 || dbgroup7[i+1] ==1
                                || dbgroup8[i+1] ==1){
                            btngg[i].setEnabled(false);
                        }else{
                            btngg[i].setEnabled(true);
                        }
                    }
                    if(dbgroup2[0]==1){ //// 2번 그룹이 존재한다면;;
                        for(int i=0; i<35; i++){
                            btngg[i].setEnabled(false);
                        }
                    }

                }
            }
        });
        Button Group3Set = (Button) findViewById(R.id.Group3Set);
        Group3Set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (group[2] == 0) {
                    groupSize = 1;
                    resetGroup();
                    btnGroup3Set.setBackgroundResource(R.drawable.groupbutton);
                    group[2] = 1;
                    dbHelper.searchGroup1();
                    dbHelper.searchGroup2();
                    dbHelper.searchGroup3();
                    dbHelper.searchGroup4();
                    dbHelper.searchGroup5();
                    dbHelper.searchGroup6();
                    dbHelper.searchGroup7();
                    dbHelper.searchGroup8();

                    for(int i=0; i<35; i++){
                        if(dbgroup1[i+1] ==1 || dbgroup2[i+1] ==1 || dbgroup4[i+1] ==1 || dbgroup5[i+1] ==1 || dbgroup6[i+1] ==1 || dbgroup7[i+1] ==1
                                || dbgroup8[i+1] ==1){
                            btngg[i].setEnabled(false);
                        }else{
                            btngg[i].setEnabled(true);
                        }
                    }
                    if(dbgroup3[0]==1){ //// 3번 그룹이 존재한다면;;
                        for(int i=0; i<35; i++){
                            btngg[i].setEnabled(false);
                        }
                    }

                }
            }
        });
        Button Group4Set = (Button) findViewById(R.id.Group4Set);
        Group4Set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (group[3] == 0) {
                    groupSize = 1;
                    resetGroup();
                    btnGroup4Set.setBackgroundResource(R.drawable.groupbutton);
                    group[3] = 1;
                    dbHelper.searchGroup1();
                    dbHelper.searchGroup2();
                    dbHelper.searchGroup3();
                    dbHelper.searchGroup4();
                    dbHelper.searchGroup5();
                    dbHelper.searchGroup6();
                    dbHelper.searchGroup7();
                    dbHelper.searchGroup8();

                    for(int i=0; i<35; i++){
                        if(dbgroup1[i+1] ==1 || dbgroup2[i+1] ==1 || dbgroup3[i+1] ==1 || dbgroup5[i+1] ==1 || dbgroup6[i+1] ==1 || dbgroup7[i+1] ==1
                                || dbgroup8[i+1] ==1){
                            btngg[i].setEnabled(false);
                        }else{
                            btngg[i].setEnabled(true);
                        }
                    }
                    if(dbgroup4[0]==1){ //// 3번 그룹이 존재한다면;;
                        for(int i=0; i<35; i++){
                            btngg[i].setEnabled(false);
                        }
                    }

                }
            }
        });
        Button Group5Set = (Button) findViewById(R.id.Group5Set);
        Group5Set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (group[4] == 0) {
                    groupSize = 1;
                    resetGroup();
                    btnGroup5Set.setBackgroundResource(R.drawable.groupbutton);
                    group[4] = 1;
                    dbHelper.searchGroup1();
                    dbHelper.searchGroup2();
                    dbHelper.searchGroup3();
                    dbHelper.searchGroup4();
                    dbHelper.searchGroup5();
                    dbHelper.searchGroup6();
                    dbHelper.searchGroup7();
                    dbHelper.searchGroup8();

                    for(int i=0; i<35; i++){
                        if(dbgroup1[i+1] ==1 || dbgroup2[i+1] ==1 || dbgroup3[i+1] ==1 || dbgroup4[i+1] ==1 || dbgroup6[i+1] ==1 || dbgroup7[i+1] ==1
                                || dbgroup8[i+1] ==1){
                            btngg[i].setEnabled(false);
                        }else{
                            btngg[i].setEnabled(true);
                        }
                    }
                    if(dbgroup5[0]==1){ //// 3번 그룹이 존재한다면;;
                        for(int i=0; i<35; i++){
                            btngg[i].setEnabled(false);
                        }
                    }

                }
            }
        });
        Button Group6Set = (Button) findViewById(R.id.Group6Set);
        Group6Set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (group[5] == 0) {
                    groupSize = 1;
                    resetGroup();
                    btnGroup6Set.setBackgroundResource(R.drawable.groupbutton);
                    group[5] = 1;
                    dbHelper.searchGroup1();
                    dbHelper.searchGroup2();
                    dbHelper.searchGroup3();
                    dbHelper.searchGroup4();
                    dbHelper.searchGroup5();
                    dbHelper.searchGroup6();
                    dbHelper.searchGroup7();
                    dbHelper.searchGroup8();

                    for(int i=0; i<35; i++){
                        if(dbgroup1[i+1] ==1 || dbgroup2[i+1] ==1 || dbgroup3[i+1] ==1 || dbgroup4[i+1] ==1 || dbgroup5[i+1] ==1 || dbgroup7[i+1] ==1
                                || dbgroup8[i+1] ==1){
                            btngg[i].setEnabled(false);
                        }else{
                            btngg[i].setEnabled(true);
                        }
                    }
                    if(dbgroup6[0]==1){ //// 3번 그룹이 존재한다면;;
                        for(int i=0; i<35; i++){
                            btngg[i].setEnabled(false);
                        }
                    }

                }
            }
        });
        Button Group7Set = (Button) findViewById(R.id.Group7Set);
        Group7Set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (group[6] == 0) {
                    groupSize = 1;
                    resetGroup();
                    btnGroup7Set.setBackgroundResource(R.drawable.groupbutton);
                    group[6] = 1;
                    dbHelper.searchGroup1();
                    dbHelper.searchGroup2();
                    dbHelper.searchGroup3();
                    dbHelper.searchGroup4();
                    dbHelper.searchGroup5();
                    dbHelper.searchGroup6();
                    dbHelper.searchGroup7();
                    dbHelper.searchGroup8();

                    for(int i=0; i<35; i++){
                        if(dbgroup1[i+1] ==1 || dbgroup2[i+1] ==1 || dbgroup3[i+1] ==1 || dbgroup4[i+1] ==1 || dbgroup5[i+1] ==1 || dbgroup6[i+1] ==1
                                || dbgroup8[i+1] ==1){
                            btngg[i].setEnabled(false);
                        }else{
                            btngg[i].setEnabled(true);
                        }
                    }
                    if(dbgroup7[0]==1){ //// 3번 그룹이 존재한다면;;
                        for(int i=0; i<35; i++){
                            btngg[i].setEnabled(false);
                        }
                    }

                }
            }
        });
        Button Group8Set = (Button) findViewById(R.id.Group8Set);
        Group8Set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (group[7] == 0) {
                    groupSize = 1;
                    resetGroup();
                    btnGroup8Set.setBackgroundResource(R.drawable.groupbutton);
                    group[7] = 1;
                    dbHelper.searchGroup1();
                    dbHelper.searchGroup2();
                    dbHelper.searchGroup3();
                    dbHelper.searchGroup4();
                    dbHelper.searchGroup5();
                    dbHelper.searchGroup6();
                    dbHelper.searchGroup7();
                    dbHelper.searchGroup8();

                    for(int i=0; i<35; i++){
                        if(dbgroup1[i+1] ==1 || dbgroup2[i+1] ==1 || dbgroup3[i+1] ==1 || dbgroup4[i+1] ==1 || dbgroup5[i+1] ==1 || dbgroup6[i+1] ==1 || dbgroup7[i+1] ==1){
                            btngg[i].setEnabled(false);
                        }else{
                            btngg[i].setEnabled(true);
                        }
                    }
                    if(dbgroup8[0]==1){ //// 3번 그룹이 존재한다면;;
                        for(int i=0; i<35; i++){
                            btngg[i].setEnabled(false);
                        }
                    }

                }
            }
        });
        //그룹부분에서의 조명버튼입니다.
        //그룹부분에서의 조명버튼입니다.
        //그룹부분에서의 조명버튼입니다.

        Button btn1g = (Button) findViewById(R.id.btn1g);
        btn1g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btng[0] == 0) {
                    btngg[0].setBackgroundResource(R.drawable.buttonforgroupon);
                    btng[0] = 1;
                } else {
                    btngg[0].setBackgroundResource(R.drawable.buttonforgroupoff);
                    btng[0] = 0;
                }
            }
        });
        Button btn2g = (Button) findViewById(R.id.btn2g);
        btn2g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btng[1] == 0) {
                    btngg[1].setBackgroundResource(R.drawable.buttonforgroupon);
                    btng[1] = 1;
                } else {
                    btngg[1].setBackgroundResource(R.drawable.buttonforgroupoff);
                    btng[1] = 0;
                }
            }
        });
        Button btn3g = (Button) findViewById(R.id.btn3g);
        btn3g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btng[2] == 0) {
                    btngg[2].setBackgroundResource(R.drawable.buttonforgroupon);
                    btng[2] = 1;
                } else {
                    btngg[2].setBackgroundResource(R.drawable.buttonforgroupoff);
                    btng[2] = 0;
                }
            }
        });
        Button btn4g = (Button) findViewById(R.id.btn4g);
        btn4g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btng[3] == 0) {
                    btngg[3].setBackgroundResource(R.drawable.buttonforgroupon);
                    btng[3] = 1;
                } else {
                    btngg[3].setBackgroundResource(R.drawable.buttonforgroupoff);
                    btng[3] = 0;
                }
            }
        });
        Button btn5g = (Button) findViewById(R.id.btn5g);
        btn5g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btng[4] == 0) {
                    btngg[4].setBackgroundResource(R.drawable.buttonforgroupon);
                    btng[4] = 1;
                } else {
                    btngg[4].setBackgroundResource(R.drawable.buttonforgroupoff);
                    btng[4] = 0;
                }
            }
        });
        Button btn6g = (Button) findViewById(R.id.btn6g);
        btn6g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btng[5] == 0) {
                    btngg[5].setBackgroundResource(R.drawable.buttonforgroupon);
                    btng[5] = 1;
                } else {
                    btngg[5].setBackgroundResource(R.drawable.buttonforgroupoff);
                    btng[5] = 0;
                }
            }
        });
        Button btn7g = (Button) findViewById(R.id.btn7g);
        btn7g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btng[6] == 0) {
                    btngg[6].setBackgroundResource(R.drawable.buttonforgroupon);
                    btng[6] = 1;
                } else {
                    btngg[6].setBackgroundResource(R.drawable.buttonforgroupoff);
                    btng[6] = 0;
                }
            }
        });
        Button btn8g = (Button) findViewById(R.id.btn8g);
        btn8g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btng[7] == 0) {
                    btngg[7].setBackgroundResource(R.drawable.buttonforgroupon);
                    btng[7] = 1;
                } else {
                    btngg[7].setBackgroundResource(R.drawable.buttonforgroupoff);
                    btng[7] = 0;
                }
            }
        });
        Button btn9g = (Button) findViewById(R.id.btn9g);
        btn9g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btng[8] == 0) {
                    btngg[8].setBackgroundResource(R.drawable.buttonforgroupon);
                    btng[8] = 1;
                } else {
                    btngg[8].setBackgroundResource(R.drawable.buttonforgroupoff);
                    btng[8] = 0;
                }
            }
        });
        Button btn10g = (Button) findViewById(R.id.btn10g);
        btn10g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btng[9] == 0) {
                    btngg[9].setBackgroundResource(R.drawable.buttonforgroupon);
                    btng[9] = 1;
                } else {
                    btngg[9].setBackgroundResource(R.drawable.buttonforgroupoff);
                    btng[9] = 0;
                }
            }
        });
        Button btn11g = (Button) findViewById(R.id.btn11g);
        btn11g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btng[10] == 0) {
                    btngg[10].setBackgroundResource(R.drawable.buttonforgroupon);
                    btng[10] = 1;
                } else {
                    btngg[10].setBackgroundResource(R.drawable.buttonforgroupoff);
                    btng[10] = 0;
                }
            }
        });
        Button btn12g = (Button) findViewById(R.id.btn12g);
        btn12g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btng[11] == 0) {
                    btngg[11].setBackgroundResource(R.drawable.buttonforgroupon);
                    btng[11] = 1;
                } else {
                    btngg[11].setBackgroundResource(R.drawable.buttonforgroupoff);
                    btng[11] = 0;
                }
            }
        });
        Button btn13g = (Button) findViewById(R.id.btn13g);
        btn13g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btng[12] == 0) {
                    btngg[12].setBackgroundResource(R.drawable.buttonforgroupon);
                    btng[12] = 1;
                } else {
                    btngg[12].setBackgroundResource(R.drawable.buttonforgroupoff);
                    btng[12] = 0;
                }
            }
        });
        Button btn14g = (Button) findViewById(R.id.btn14g);
        btn14g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btng[13] == 0) {
                    btngg[13].setBackgroundResource(R.drawable.buttonforgroupon);
                    btng[13] = 1;
                } else {
                    btngg[13].setBackgroundResource(R.drawable.buttonforgroupoff);
                    btng[13] = 0;
                }
            }
        });
        Button btn15g = (Button) findViewById(R.id.btn15g);
        btn15g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btng[14] == 0) {
                    btngg[14].setBackgroundResource(R.drawable.buttonforgroupon);
                    btng[14] = 1;
                } else {
                    btngg[14].setBackgroundResource(R.drawable.buttonforgroupoff);
                    btng[14] = 0;
                }
            }
        });
        Button btn16g = (Button) findViewById(R.id.btn16g);
        btn16g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btng[15] == 0) {
                    btngg[15].setBackgroundResource(R.drawable.buttonforgroupon);
                    btng[15] = 1;
                } else {
                    btngg[15].setBackgroundResource(R.drawable.buttonforgroupoff);
                    btng[15] = 0;
                }
            }
        });
        Button btn17g = (Button) findViewById(R.id.btn17g);
        btn17g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btng[16] == 0) {
                    btngg[16].setBackgroundResource(R.drawable.buttonforgroupon);
                    btng[16] = 1;
                } else {
                    btngg[16].setBackgroundResource(R.drawable.buttonforgroupoff);
                    btng[16] = 0;
                }
            }
        });
        Button btn18g = (Button) findViewById(R.id.btn18g);
        btn18g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btng[17] == 0) {
                    btngg[17].setBackgroundResource(R.drawable.buttonforgroupon);
                    btng[17] = 1;
                } else {
                    btngg[17].setBackgroundResource(R.drawable.buttonforgroupoff);
                    btng[17] = 0;
                }
            }
        });
        Button btn19g = (Button) findViewById(R.id.btn19g);
        btn19g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btng[18] == 0) {
                    btngg[18].setBackgroundResource(R.drawable.buttonforgroupon);
                    btng[18] = 1;
                } else {
                    btngg[18].setBackgroundResource(R.drawable.buttonforgroupoff);
                    btng[18] = 0;
                }
            }
        });
        Button btn20g = (Button) findViewById(R.id.btn20g);
        btn20g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btng[19] == 0) {
                    btngg[19].setBackgroundResource(R.drawable.buttonforgroupon);
                    btng[19] = 1;
                } else {
                    btngg[19].setBackgroundResource(R.drawable.buttonforgroupoff);
                    btng[19] = 0;
                }
            }
        });
        Button btn21g = (Button) findViewById(R.id.btn21g);
        btn21g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btng[20] == 0) {
                    btngg[20].setBackgroundResource(R.drawable.buttonforgroupon);
                    btng[20] = 1;
                } else {
                    btngg[20].setBackgroundResource(R.drawable.buttonforgroupoff);
                    btng[20] = 0;
                }
            }
        });
        Button btn22g = (Button) findViewById(R.id.btn22g);
        btn22g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btng[21] == 0) {
                    btngg[21].setBackgroundResource(R.drawable.buttonforgroupon);
                    btng[21] = 1;
                } else {
                    btngg[21].setBackgroundResource(R.drawable.buttonforgroupoff);
                    btng[21] = 0;
                }
            }
        });
        Button btn23g = (Button) findViewById(R.id.btn23g);
        btn23g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btng[22] == 0) {
                    btngg[22].setBackgroundResource(R.drawable.buttonforgroupon);
                    btng[22] = 1;
                } else {
                    btngg[22].setBackgroundResource(R.drawable.buttonforgroupoff);
                    btng[22] = 0;
                }
            }
        });
        Button btn24g = (Button) findViewById(R.id.btn24g);
        btn24g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btng[23] == 0) {
                    btngg[23].setBackgroundResource(R.drawable.buttonforgroupon);
                    btng[23] = 1;
                } else {
                    btngg[23].setBackgroundResource(R.drawable.buttonforgroupoff);
                    btng[23] = 0;
                }
            }
        });
        Button btn25g = (Button) findViewById(R.id.btn25g);
        btn25g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btng[24] == 0) {
                    btngg[24].setBackgroundResource(R.drawable.buttonforgroupon);
                    btng[24] = 1;
                } else {
                    btngg[24].setBackgroundResource(R.drawable.buttonforgroupoff);
                    btng[24] = 0;
                }
            }
        });
        Button btn26g = (Button) findViewById(R.id.btn26g);
        btn26g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btng[25] == 0) {
                    btngg[25].setBackgroundResource(R.drawable.buttonforgroupon);
                    btng[25] = 1;
                } else {
                    btngg[25].setBackgroundResource(R.drawable.buttonforgroupoff);
                    btng[25] = 0;
                }
            }
        });
        Button btn27g = (Button) findViewById(R.id.btn27g);
        btn27g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btng[26] == 0) {
                    btngg[26].setBackgroundResource(R.drawable.buttonforgroupon);
                    btng[26] = 1;
                } else {
                    btngg[26].setBackgroundResource(R.drawable.buttonforgroupoff);
                    btng[26] = 0;
                }
            }
        });
        Button btn28g = (Button) findViewById(R.id.btn28g);
        btn28g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btng[27] == 0) {
                    btngg[27].setBackgroundResource(R.drawable.buttonforgroupon);
                    btng[27] = 1;
                } else {
                    btngg[27].setBackgroundResource(R.drawable.buttonforgroupoff);
                    btng[27] = 0;
                }
            }
        });
        Button btn29g = (Button) findViewById(R.id.btn29g);
        btn29g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btng[28] == 0) {
                    btngg[28].setBackgroundResource(R.drawable.buttonforgroupon);
                    btng[28] = 1;
                } else {
                    btngg[28].setBackgroundResource(R.drawable.buttonforgroupoff);
                    btng[28] = 0;
                }
            }
        });
        Button btn30g = (Button) findViewById(R.id.btn30g);
        btn30g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btng[29] == 0) {
                    btngg[29].setBackgroundResource(R.drawable.buttonforgroupon);
                    btng[29] = 1;
                } else {
                    btngg[29].setBackgroundResource(R.drawable.buttonforgroupoff);
                    btng[29] = 0;
                }
            }
        });
        Button btn31g = (Button) findViewById(R.id.btn31g);
        btn31g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btng[30] == 0) {
                    btngg[30].setBackgroundResource(R.drawable.buttonforgroupon);
                    btng[30] = 1;
                } else {
                    btngg[30].setBackgroundResource(R.drawable.buttonforgroupoff);
                    btng[30] = 0;
                }
            }
        });
        Button btn32g = (Button) findViewById(R.id.btn32g);
        btn32g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btng[31] == 0) {
                    btngg[31].setBackgroundResource(R.drawable.buttonforgroupon);
                    btng[31] = 1;
                } else {
                    btngg[31].setBackgroundResource(R.drawable.buttonforgroupoff);
                    btng[31] = 0;
                }
            }
        });
        Button btn33g = (Button) findViewById(R.id.btn33g);
        btn33g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btng[32] == 0) {
                    btngg[32].setBackgroundResource(R.drawable.buttonforgroupon);
                    btng[32] = 1;
                } else {
                    btngg[32].setBackgroundResource(R.drawable.buttonforgroupoff);
                    btng[32] = 0;
                }
            }
        });
        Button btn34g = (Button) findViewById(R.id.btn34g);
        btn34g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btng[33] == 0) {
                    btngg[33].setBackgroundResource(R.drawable.buttonforgroupon);
                    btng[33] = 1;
                } else {
                    btngg[33].setBackgroundResource(R.drawable.buttonforgroupoff);
                    btng[33] = 0;
                }
            }
        });
        Button btn35g = (Button) findViewById(R.id.btn35g);
        btn35g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btng[34] == 0) {
                    btngg[34].setBackgroundResource(R.drawable.buttonforgroupon);
                    btng[34] = 1;
                } else {
                    btngg[34].setBackgroundResource(R.drawable.buttonforgroupoff);
                    btng[34] = 0;
                }
            }
        });


        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }
    //serial function

    public void onResume() {
        Log.d(TAG, "Enter onResume");
        super.onResume();
        String action =  getIntent().getAction();
        Log.d(TAG, "onResume:"+action);

        //if (UsbManager.ACTION_USB_DEVICE_ATTACHED.equals(action))
        if(!mSerial.isConnected()) {
            if (SHOW_DEBUG) {
                Log.d(TAG, "New instance : " + mSerial);
            }

            if( !mSerial.enumerate() ) {

                Toast.makeText(this, "no more devices found", Toast.LENGTH_SHORT).show();
                return;
            } else {
                Log.d(TAG, "onResume:enumerate succeeded!");
            }
        }//if isConnected
        Toast.makeText(this, "attached", Toast.LENGTH_SHORT).show();

        Log.d(TAG, "Leave onResume");
    }
    private void writeDataToSerial() {
        if (!mSerial.InitByBaudRate(mBaudrate,700)) {
            if(!mSerial.PL2303Device_IsHasPermission()) {
                Toast.makeText(this, "cannot open, maybe no permission", Toast.LENGTH_SHORT).show();
            }
            if(mSerial.PL2303Device_IsHasPermission() && (!mSerial.PL2303Device_IsSupportChip())) {
                Toast.makeText(this, "cannot open, maybe this chip has no support, please use PL2303HXD / RA / EA chip.", Toast.LENGTH_SHORT).show();
            }
        } else {
        }
        mBaudrate = PL2303Driver.BaudRate.B9600;
        if(null==mSerial)
            return;
        if(!mSerial.isConnected())
            return;
        if(arraySize >0){
            int res = mSerial.write(OffArray, arraySize+4);
        }
        if(arraySizeforgroup>0){
            int res = mSerial.write(OffArray, arraySizeforgroup+4);
        }


    }
    private void writeDataToSerial2() {
        if (!mSerial.InitByBaudRate(mBaudrate,700)) {
            if(!mSerial.PL2303Device_IsHasPermission()) {
                Toast.makeText(this, "cannot open, maybe no permission", Toast.LENGTH_SHORT).show();
            }
            if(mSerial.PL2303Device_IsHasPermission() && (!mSerial.PL2303Device_IsSupportChip())) {
                Toast.makeText(this, "cannot open, maybe this chip has no support, please use PL2303HXD / RA / EA chip.", Toast.LENGTH_SHORT).show();
            }
        } else {
        }
        mBaudrate = PL2303Driver.BaudRate.B9600;
        if(null==mSerial)
            return;
        if(!mSerial.isConnected())
            return;
        if(arraySize >0){
            int res = mSerial.write(OnArray, arraySize+4);
        }
        if(arraySizeforgroup>0){
            int res = mSerial.write(OnArray, arraySizeforgroup+4);
        }

    }
    private void writeDataToSerial3() {
        if (!mSerial.InitByBaudRate(mBaudrate,700)) {
            if(!mSerial.PL2303Device_IsHasPermission()) {
                Toast.makeText(this, "cannot open, maybe no permission", Toast.LENGTH_SHORT).show();
            }
            if(mSerial.PL2303Device_IsHasPermission() && (!mSerial.PL2303Device_IsSupportChip())) {
                Toast.makeText(this, "cannot open, maybe this chip has no support, please use PL2303HXD / RA / EA chip.", Toast.LENGTH_SHORT).show();
            }
        } else {
        }
        mBaudrate = PL2303Driver.BaudRate.B9600;
        if(null==mSerial)
            return;
        if(!mSerial.isConnected())
            return;
        if(arraySize >0){
            int res = mSerial.write(UpArray, arraySize+4);
        }
        if(arraySizeforgroup>0){
            int res = mSerial.write(UpArray, arraySizeforgroup+4);
        }

    }
    private void writeDataToSerial4() {
        if (!mSerial.InitByBaudRate(mBaudrate,700)) {
            if(!mSerial.PL2303Device_IsHasPermission()) {
                Toast.makeText(this, "cannot open, maybe no permission", Toast.LENGTH_SHORT).show();
            }
            if(mSerial.PL2303Device_IsHasPermission() && (!mSerial.PL2303Device_IsSupportChip())) {
                Toast.makeText(this, "cannot open, maybe this chip has no support, please use PL2303HXD / RA / EA chip.", Toast.LENGTH_SHORT).show();
            }
        } else {
        }
        mBaudrate = PL2303Driver.BaudRate.B9600;
        if(null==mSerial)
            return;
        if(!mSerial.isConnected())
            return;
        if(arraySize >0){
            int res = mSerial.write(DownArray, arraySize+4);
        }
        if(arraySizeforgroup>0){
            int res = mSerial.write(DownArray, arraySizeforgroup+4);
        }

    }
    private void writeDataToSerial5() {
        if (!mSerial.InitByBaudRate(mBaudrate,700)) {
            if(!mSerial.PL2303Device_IsHasPermission()) {
                Toast.makeText(this, "cannot open, maybe no permission", Toast.LENGTH_SHORT).show();
            }
            if(mSerial.PL2303Device_IsHasPermission() && (!mSerial.PL2303Device_IsSupportChip())) {
                Toast.makeText(this, "cannot open, maybe this chip has no support, please use PL2303HXD / RA / EA chip.", Toast.LENGTH_SHORT).show();
            }
        } else {
        }
        mBaudrate = PL2303Driver.BaudRate.B9600;
        if(null==mSerial)
            return;
        if(!mSerial.isConnected())
            return;
        if(arraySize >0){
            int res = mSerial.write(StopArray, arraySize+4);
        }
        if(arraySizeforgroup>0){
            int res = mSerial.write(StopArray, arraySizeforgroup+4);
        }

    }
    //serial function

    public void checkLightState() {
        if(arraySize >0 ){
            for (int i = 0; i < 35; i++) {
                if (arr[i] != 0) {
                    arr[i] = 0;
                    temp[i] = 0;
                    tempControl[i] = 0;
                }
            }

            btn1.setBackgroundResource(R.drawable.buttonforgroupoff);
            btn2.setBackgroundResource(R.drawable.buttonforgroupoff);
            btn3.setBackgroundResource(R.drawable.buttonforgroupoff);
            btn4.setBackgroundResource(R.drawable.buttonforgroupoff);
            btn5.setBackgroundResource(R.drawable.buttonforgroupoff);
            btn6.setBackgroundResource(R.drawable.buttonforgroupoff);
            btn7.setBackgroundResource(R.drawable.buttonforgroupoff);
            btn8.setBackgroundResource(R.drawable.buttonforgroupoff);
            btn9.setBackgroundResource(R.drawable.buttonforgroupoff);
            btn10.setBackgroundResource(R.drawable.buttonforgroupoff);
            btn11.setBackgroundResource(R.drawable.buttonforgroupoff);
            btn12.setBackgroundResource(R.drawable.buttonforgroupoff);
            btn13.setBackgroundResource(R.drawable.buttonforgroupoff);
            btn14.setBackgroundResource(R.drawable.buttonforgroupoff);
            btn15.setBackgroundResource(R.drawable.buttonforgroupoff);
            btn16.setBackgroundResource(R.drawable.buttonforgroupoff);
            btn17.setBackgroundResource(R.drawable.buttonforgroupoff);
            btn18.setBackgroundResource(R.drawable.buttonforgroupoff);
            btn19.setBackgroundResource(R.drawable.buttonforgroupoff);
            btn20.setBackgroundResource(R.drawable.buttonforgroupoff);
            btn21.setBackgroundResource(R.drawable.buttonforgroupoff);
            btn22.setBackgroundResource(R.drawable.buttonforgroupoff);
            btn23.setBackgroundResource(R.drawable.buttonforgroupoff);
            btn24.setBackgroundResource(R.drawable.buttonforgroupoff);
            btn25.setBackgroundResource(R.drawable.buttonforgroupoff);
            btn26.setBackgroundResource(R.drawable.buttonforgroupoff);
            btn27.setBackgroundResource(R.drawable.buttonforgroupoff);
            btn28.setBackgroundResource(R.drawable.buttonforgroupoff);
            btn29.setBackgroundResource(R.drawable.buttonforgroupoff);
            btn30.setBackgroundResource(R.drawable.buttonforgroupoff);
            btn31.setBackgroundResource(R.drawable.buttonforgroupoff);
            btn32.setBackgroundResource(R.drawable.buttonforgroupoff);
            btn33.setBackgroundResource(R.drawable.buttonforgroupoff);
            btn34.setBackgroundResource(R.drawable.buttonforgroupoff);
            btn35.setBackgroundResource(R.drawable.buttonforgroupoff);
            arraySize = 0;
        }
    }

    public void checkGroupState() {
        if(groupControl[0] == 1 || groupControl[1] == 1 || groupControl[2] == 1 || groupControl[3] == 1 || groupControl[4] == 1 || groupControl[5] == 1 || groupControl[6] == 1 || groupControl[7] == 1){
            for (int i = 0; i < 8; i++) {
                if (groupControl[i] != 0) {
                    groupControl[i] = 0;
                }
            }
            for (int i = 0; i < 35; i++) {
                temp[i] = 0;
                tempControl[i] = 0;
                tempforgroup[i]=0;
                tempControlforgroup[i]=0;

            }
            Group1.setBackgroundResource(R.drawable.smbutton);
            Group2.setBackgroundResource(R.drawable.smbutton);
            Group3.setBackgroundResource(R.drawable.smbutton);
            Group4.setBackgroundResource(R.drawable.smbutton);
            Group5.setBackgroundResource(R.drawable.smbutton);
            Group6.setBackgroundResource(R.drawable.smbutton);
            Group7.setBackgroundResource(R.drawable.smbutton);
            Group8.setBackgroundResource(R.drawable.smbutton);
            arraySizeforgroup=0;
        }


    }

    public void resetGroup() {
        if (groupSize > 0) {
            group[0] = 0;
            group[1] = 0;
            group[2] = 0;
            group[3] = 0;
            group[4] = 0;
            group[5] = 0;
            group[6] = 0;
            group[7] = 0;
            btnGroup1Set.setBackgroundResource(R.drawable.smbutton);
            btnGroup2Set.setBackgroundResource(R.drawable.smbutton);
            btnGroup3Set.setBackgroundResource(R.drawable.smbutton);
            btnGroup4Set.setBackgroundResource(R.drawable.smbutton);
            btnGroup5Set.setBackgroundResource(R.drawable.smbutton);
            btnGroup6Set.setBackgroundResource(R.drawable.smbutton);
            btnGroup7Set.setBackgroundResource(R.drawable.smbutton);
            btnGroup8Set.setBackgroundResource(R.drawable.smbutton);
            groupSize = 0;
        }
    }

    public void resetOnArray() {
        for (int i = 0; i < 35; i++) {
            OnArray[i] = 0;
            temp[i]=tempControl[i];
            tempforgroup[i]=tempControlforgroup[i];
        }
    }
    public void resetOffArray() {
        for (int i = 0; i < 35; i++) {
            OffArray[i] = 0;
            temp[i]=tempControl[i];
            tempforgroup[i]=tempControlforgroup[i];
        }
    }
    public void resetUpArray() {
        for (int i = 0; i < 35; i++) {
            UpArray[i] = 0;
            temp[i]=tempControl[i];
            tempforgroup[i]=tempControlforgroup[i];
        }
    }
    public void resetDownArray() {
        for (int i = 0; i < 35; i++) {
            DownArray[i] = 0;
            temp[i]=tempControl[i];
            tempforgroup[i]=tempControlforgroup[i];
        }
    }
    public void resetStopArray() {
        for (int i = 0; i < 35; i++) {
            StopArray[i] = 0;
            temp[i]=tempControl[i];
            tempforgroup[i]=tempControlforgroup[i];
        }
    }

    public void setupOn() {
        OnArray[0] = (byte) 0xFA;
        OnArray[1] = (byte) 0xEF;
        OnArray[2] = (byte) arraySize;
        OnArray[arraySize + 3] = 0x03;
            for (int i = 3; i < arraySize + 3; i++) {
                for(int k=0; k<35; k++){
                    if(temp[k] > 0){
                        OnArray[i] = temp[k];
                        temp[k]=0;
                        break;
                }
            }
        }
    }
    public void setupOn2() {
                if(groupControl[0] == 1 || groupControl[1] == 1 || groupControl[2] == 1 || groupControl[3] == 1 || groupControl[4] == 1 || groupControl[5] == 1 || groupControl[6] == 1 || groupControl[7] == 1){
                    OnArray[0] = (byte) 0xFA;
                    OnArray[1] = (byte) 0xEF;
                    OnArray[2] = (byte) arraySizeforgroup;
                    OnArray[arraySizeforgroup + 3] = 0x03;
                    for (int i = 3; i < arraySizeforgroup + 3; i++) {
                        for(int k=0; k<35; k++){
                            if(tempforgroup[k] > 0){
                                OnArray[i] = tempforgroup[k];
                                tempforgroup[k]=0;
                                break;
                            }
                        }
                    }
                }


    }
    public void setupOff() {
        if(arraySize >0){
            OffArray[0] = (byte) 0xFA;
            OffArray[1] = (byte) 0xEF;
            OffArray[2] = (byte) arraySize;
            OffArray[arraySize + 3] = 0x04;
            for (int i = 3; i < arraySize + 3; i++) {
                for(int k=0; k<35; k++){
                    if(temp[k] > 0x00){
                        OffArray[i] = temp[k];
                        temp[k]=0;
                        break;
                    }
                }
            }
        }
    }
    public void setupOff2() {
        if(groupControl[0] == 1 || groupControl[1] == 1 || groupControl[2] == 1 || groupControl[3] == 1 || groupControl[4] == 1 || groupControl[5] == 1 || groupControl[6] == 1 || groupControl[7] == 1){
            OffArray[0] = (byte) 0xFA;
            OffArray[1] = (byte) 0xEF;
            OffArray[2] = (byte) arraySizeforgroup;
            OffArray[arraySizeforgroup + 3] = 0x04;
            for (int i = 3; i < arraySizeforgroup + 3; i++) {
                for(int k=0; k<35; k++){
                    if(tempforgroup[k] > 0x00){
                        OffArray[i] = tempforgroup[k];
                        tempforgroup[k]=0;
                        break;
                    }
                }
            }
        }
    }
    public void setupUp() {
        if(arraySize >0){
            UpArray[0] = (byte) 0xFA;
            UpArray[1] = (byte) 0xEF;
            UpArray[2] = (byte) arraySize;
            UpArray[arraySize + 3] = 0x01;
            for (int i = 3; i < arraySize + 3; i++) {
                for(int k=0; k<35; k++){
                    if(temp[k] > 0x00){
                        UpArray[i] = temp[k];
                        temp[k]=0;
                        break;
                    }
                }
            }
        }
    }
    public void setupUp2() {
        if(groupControl[0] == 1 || groupControl[1] == 1 || groupControl[2] == 1 || groupControl[3] == 1 || groupControl[4] == 1 || groupControl[5] == 1 || groupControl[6] == 1 || groupControl[7] == 1){
            UpArray[0] = (byte) 0xFA;
            UpArray[1] = (byte) 0xEF;
            UpArray[2] = (byte) arraySizeforgroup;
            UpArray[arraySizeforgroup + 3] = 0x01;
            for (int i = 3; i < arraySizeforgroup + 3; i++) {
                for(int k=0; k<35; k++){
                    if(tempforgroup[k] > 0x00){
                        UpArray[i] = tempforgroup[k];
                        tempforgroup[k]=0;
                        break;
                    }
                }
            }
        }
    }

    public void setupDown() {
        DownArray[0] = (byte) 0xFA;
        DownArray[1] = (byte) 0xEF;
        DownArray[2] = (byte) arraySize;
        DownArray[arraySize + 3] = 0x02;
        for (int i = 3; i < arraySize + 3; i++) {
            for(int k=0; k<35; k++){
                if(temp[k] > 0x00){
                    DownArray[i] = temp[k];
                    temp[k]=0;
                    break;
                }
            }
        }
    }
    public void setupDown2() {
        if(groupControl[0] == 1 || groupControl[1] == 1 || groupControl[2] == 1 || groupControl[3] == 1 || groupControl[4] == 1 || groupControl[5] == 1 || groupControl[6] == 1 || groupControl[7] == 1){
            DownArray[0] = (byte) 0xFA;
            DownArray[1] = (byte) 0xEF;
            DownArray[2] = (byte) arraySizeforgroup;
            DownArray[arraySizeforgroup + 3] = 0x02;
            for (int i = 3; i < arraySizeforgroup + 3; i++) {
                for(int k=0; k<35; k++){
                    if(tempforgroup[k] > 0x00){
                        DownArray[i] = tempforgroup[k];
                        tempforgroup[k]=0;
                        break;
                    }
                }
            }
        }
    }
    public void setupStop() {
        StopArray[0] = (byte) 0xFA;
        StopArray[1] = (byte) 0xEF;
        StopArray[2] = (byte) arraySize;
        StopArray[arraySize + 3] = 0x00;
        for (int i = 3; i < arraySize + 3; i++) {
            for(int k=0; k<35; k++){
                if(temp[k] > 0x00){
                    StopArray[i] = temp[k];
                    temp[k]=0;
                    break;
                }
            }
        }
}
    public void setupStop2() {
        if(groupControl[0] == 1 || groupControl[1] == 1 || groupControl[2] == 1 || groupControl[3] == 1 || groupControl[4] == 1 || groupControl[5] == 1 || groupControl[6] == 1 || groupControl[7] == 1){
            StopArray[0] = (byte) 0xFA;
            StopArray[1] = (byte) 0xEF;
            StopArray[2] = (byte) arraySizeforgroup;
            StopArray[arraySizeforgroup + 3] = 0x00;
            for (int i = 3; i < arraySizeforgroup + 3; i++) {
                for(int k=0; k<35; k++){
                    if(tempforgroup[k] > 0x00){
                        StopArray[i] = tempforgroup[k];
                        tempforgroup[k]=0;
                        break;
                    }
                }
            }
        }
    }

    //컨트롤 모드에서 그룹입니다!!
    //컨트롤 모드에서 그룹입니다!!
    //컨트롤 모드에서 그룹입니다!!

//    public void Group3Onclick(View view) {
//        checkLightState();
//        if (group[2] == 0) {
//            group[2] = 1;
//            Group3.setBackgroundResource(R.drawable.groupbutton);
//        } else {
//            group[2] = 0;
//            Group3.setBackgroundResource(R.drawable.smbutton);
//        }
//    }
//
//    public void Group4Onclick(View view) {
//        checkLightState();
//        if (group[3] == 0) {
//            group[3] = 1;
//            Group4.setBackgroundResource(R.drawable.groupbutton);
//        } else {
//            group[3] = 0;
//            Group4.setBackgroundResource(R.drawable.smbutton);
//            ;
//        }
//    }
//
//    public void Group5Onclick(View view) {
//        checkLightState();
//        if (group[4] == 0) {
//            group[4] = 1;
//            Group5.setBackgroundResource(R.drawable.groupbutton);
//        } else {
//            group[4] = 0;
//            Group5.setBackgroundResource(R.drawable.smbutton);
//        }
//    }
//
//    public void Group6Onclick(View view) {
//        checkLightState();
//        if (group[5] == 0) {
//            group[5] = 1;
//            Group6.setBackgroundResource(R.drawable.groupbutton);
//        } else {
//            group[5] = 0;
//            Group6.setBackgroundResource(R.drawable.smbutton);
//        }
//    }
//
//    public void Group7Onclick(View view) {
//        checkLightState();
//        if (group[6] == 0) {
//            group[6] = 1;
//            Group7.setBackgroundResource(R.drawable.groupbutton);
//        } else {
//            group[6] = 0;
//            Group7.setBackgroundResource(R.drawable.smbutton);
//        }
//    }
//
//    public void Group8Onclick(View view) {
//        checkLightState();
//        if (group[7] == 0) {
//            group[7] = 1;
//            Group8.setBackgroundResource(R.drawable.groupbutton);
//        } else {
//            group[7] = 0;
//            Group8.setBackgroundResource(R.drawable.smbutton);
//        }
//    }

    //컨틀롤 부분에서 조명버튼입니다...
    //컨틀롤 부분에서 조명버튼입니다...
    //컨틀롤 부분에서 조명버튼입니다...
    public void btn1Onclick(View view) {
        checkGroupState();
        if (arr[0] == 0) {
            arr[0] = 1;
            temp[0] = 0x01;
            tempControl[0] = 0x01;
            arraySize++;
            btn1.setBackgroundResource(R.drawable.buttonforgroupon);
        } else {
            arr[0] = 0;
            temp[0] = 0;
            tempControl[0] = 0;
            arraySize--;
            btn1.setBackgroundResource(R.drawable.buttonforgroupoff);
        }
    }

    public void btn2Onclick(View view) {
        checkGroupState();
        if (arr[1] == 0) {
            arr[1] = 1;
            temp[1] = 0x02;
            tempControl[1] = 0x02;
            arraySize++;
            btn2.setBackgroundResource(R.drawable.buttonforgroupon);
        } else {
            arr[1] = 0;
            temp[1] = 0;
            tempControl[1] = 0;
            arraySize--;
            btn2.setBackgroundResource(R.drawable.buttonforgroupoff);
        }
    }

    public void btn3Onclick(View view) {
        checkGroupState();
        if (arr[2] == 0) {
            arr[2] = 1;
            temp[2] = 0x03;
            tempControl[2] = 0x03;
            arraySize++;
            btn3.setBackgroundResource(R.drawable.buttonforgroupon);
        } else {
            arr[2] = 0;
            temp[2] = 0;
            tempControl[2] = 0;
            arraySize--;
            btn3.setBackgroundResource(R.drawable.buttonforgroupoff);

        }
    }

    public void btn4Onclick(View view) {
        checkGroupState();
        if (arr[3] == 0) {
            arr[3] = 1;
            temp[3] = 0x04;
            tempControl[3] = 0x04;
            arraySize++;
            btn4.setBackgroundResource(R.drawable.buttonforgroupon);
        } else {
            arr[3] = 0;
            temp[3] = 0;
            tempControl[3] = 0;
            arraySize--;
            btn4.setBackgroundResource(R.drawable.buttonforgroupoff);

        }
    }

    public void btn5Onclick(View view) {
        checkGroupState();
        if (arr[4] == 0) {
            arr[4] = 1;
            temp[4] = 0x05;
            tempControl[4] = 0x05;
            arraySize++;
            btn5.setBackgroundResource(R.drawable.buttonforgroupon);
        } else {
            arr[4] = 0;
            temp[4] = 0;
            tempControl[4] = 0;
            arraySize--;
            btn5.setBackgroundResource(R.drawable.buttonforgroupoff);

        }
    }

    public void btn6Onclick(View view) {
        checkGroupState();
        if (arr[5] == 0) {
            arr[5] = 1;
            temp[5] = 0x06;
            tempControl[5] = 0x06;
            arraySize++;
            btn6.setBackgroundResource(R.drawable.buttonforgroupon);
        } else {
            arr[5] = 0;
            temp[5] = 0;
            tempControl[5] = 0;
            arraySize--;
            btn6.setBackgroundResource(R.drawable.buttonforgroupoff);

        }
    }

    public void btn7Onclick(View view) {
        checkGroupState();
        if (arr[6] == 0) {
            arr[6] = 1;
            temp[6] = 0x07;
            tempControl[6] = 0x07;
            arraySize++;
            btn7.setBackgroundResource(R.drawable.buttonforgroupon);
        } else {
            arr[6] = 0;
            temp[6] = 0;
            tempControl[6] = 0;
            arraySize--;
            btn7.setBackgroundResource(R.drawable.buttonforgroupoff);

        }
    }
    public void btn8Onclick(View view) {
        checkGroupState();
        if (arr[7] == 0) {
            arr[7] = 1;
            temp[7] = 0x08;
            tempControl[7] = 0x08;
            arraySize++;
            btn8.setBackgroundResource(R.drawable.buttonforgroupon);
        } else {
            arr[7] = 0;
            temp[7] = 0;
            tempControl[7] = 0;
            arraySize--;
            btn8.setBackgroundResource(R.drawable.buttonforgroupoff);

        }
    }
    public void btn9Onclick(View view) {
        checkGroupState();
        if (arr[8] == 0) {
            arr[8] = 1;
            temp[8] = 0x09;
            tempControl[8] = 0x09;
            arraySize++;
            btn9.setBackgroundResource(R.drawable.buttonforgroupon);
        } else {
            arr[8] = 0;
            temp[8] = 0;
            tempControl[8] = 0;
            arraySize--;
            btn9.setBackgroundResource(R.drawable.buttonforgroupoff);

        }
    }
    public void btn10Onclick(View view) {
        checkGroupState();
        if (arr[9] == 0) {
            arr[9] = 1;
            temp[9] = 0xA;
            tempControl[9] = 0xA;
            arraySize++;
            btn10.setBackgroundResource(R.drawable.buttonforgroupon);
        } else {
            arr[9] = 0;
            temp[9] = 0;
            tempControl[9] = 0;
            arraySize--;
            btn10.setBackgroundResource(R.drawable.buttonforgroupoff);

        }
    }
    public void btn11Onclick(View view) {
        checkGroupState();
        if (arr[10] == 0) {
            arr[10] = 1;
            temp[10] = 0xB;
            tempControl[10] = 0xB;
            arraySize++;
            btn11.setBackgroundResource(R.drawable.buttonforgroupon);
        } else {
            arr[10] = 0;
            temp[10] = 0;
            tempControl[10] = 0;
            arraySize--;
            btn11.setBackgroundResource(R.drawable.buttonforgroupoff);

        }
    }
    public void btn12Onclick(View view) {
        checkGroupState();
        if (arr[11] == 0) {
            arr[11] = 1;
            temp[11] = 0xC;
            tempControl[11] = 0xC;
            arraySize++;
            btn12.setBackgroundResource(R.drawable.buttonforgroupon);
        } else {
            arr[11] = 0;
            temp[11] = 0;
            tempControl[11] = 0;
            arraySize--;
            btn12.setBackgroundResource(R.drawable.buttonforgroupoff);

        }
    }
    public void btn13Onclick(View view) {
        checkGroupState();
        if (arr[12] == 0) {
            arr[12] = 1;
            temp[12] = 0xD;
            tempControl[12] = 0xD;
            arraySize++;
            btn13.setBackgroundResource(R.drawable.buttonforgroupon);
        } else {
            arr[12] = 0;
            temp[12] = 0;
            tempControl[12] = 0;
            arraySize--;
            btn13.setBackgroundResource(R.drawable.buttonforgroupoff);

        }
    }
    public void btn14Onclick(View view) {
        checkGroupState();
        if (arr[13] == 0) {
            arr[13] = 1;
            temp[13] = 0xE;
            tempControl[13] = 0xE;
            arraySize++;
            btn14.setBackgroundResource(R.drawable.buttonforgroupon);
        } else {
            arr[13] = 0;
            temp[13] = 0;
            tempControl[13] = 0;
            arraySize--;
            btn14.setBackgroundResource(R.drawable.buttonforgroupoff);

        }
    }
    public void btn15Onclick(View view) {
        checkGroupState();
        if (arr[14] == 0) {
            arr[14] = 1;
            temp[14] = 0xF;
            tempControl[14] = 0xF;
            arraySize++;
            btn15.setBackgroundResource(R.drawable.buttonforgroupon);
        } else {
            arr[14] = 0;
            temp[14] = 0;
            tempControl[14] = 0;
            arraySize--;
            btn15.setBackgroundResource(R.drawable.buttonforgroupoff);

        }
    }
    public void btn16Onclick(View view) {
        checkGroupState();
        if (arr[15] == 0) {
            arr[15] = 1;
            temp[15] = 0x10;
            tempControl[15] = 0x10;
            arraySize++;
            btn16.setBackgroundResource(R.drawable.buttonforgroupon);
        } else {
            arr[15] = 0;
            temp[15] = 0;
            tempControl[15] = 0;
            arraySize--;
            btn16.setBackgroundResource(R.drawable.buttonforgroupoff);

        }
    }
    public void btn17Onclick(View view) {
        checkGroupState();
        if (arr[16] == 0) {
            arr[16] = 1;
            temp[16] = 0x11;
            tempControl[16] = 0x11;
            arraySize++;
            btn17.setBackgroundResource(R.drawable.buttonforgroupon);
        } else {
            arr[16] = 0;
            temp[16] = 0;
            tempControl[16] = 0;
            arraySize--;
            btn17.setBackgroundResource(R.drawable.buttonforgroupoff);

        }
    }
    public void btn18Onclick(View view) {
        checkGroupState();
        if (arr[17] == 0) {
            arr[17] = 1;
            temp[17] = 0x12;
            tempControl[17] = 0x12;
            arraySize++;
            btn18.setBackgroundResource(R.drawable.buttonforgroupon);
        } else {
            arr[17] = 0;
            temp[17] = 0;
            tempControl[17] = 0;
            arraySize--;
            btn18.setBackgroundResource(R.drawable.buttonforgroupoff);

        }
    }
    public void btn19Onclick(View view) {
        checkGroupState();
        if (arr[18] == 0) {
            arr[18] = 1;
            temp[18] = 0x13;
            tempControl[18] = 0x13;
            arraySize++;
            btn19.setBackgroundResource(R.drawable.buttonforgroupon);
        } else {
            arr[18] = 0;
            temp[18] = 0;
            tempControl[18] = 0;
            arraySize--;
            btn19.setBackgroundResource(R.drawable.buttonforgroupoff);

        }
    }
    public void btn20Onclick(View view) {
        checkGroupState();
        if (arr[19] == 0) {
            arr[19] = 1;
            temp[19] = 0x14;
            tempControl[19] = 0x14;
            arraySize++;
            btn20.setBackgroundResource(R.drawable.buttonforgroupon);
        } else {
            arr[19] = 0;
            temp[19] = 0;
            tempControl[19] = 0;
            arraySize--;
            btn20.setBackgroundResource(R.drawable.buttonforgroupoff);

        }
    }
    public void btn21Onclick(View view) {
        checkGroupState();
        if (arr[20] == 0) {
            arr[20] = 1;
            temp[20] = 0x15;
            tempControl[20] = 0x15;
            arraySize++;
            btn21.setBackgroundResource(R.drawable.buttonforgroupon);
        } else {
            arr[20] = 0;
            temp[20] = 0;
            tempControl[20] = 0;
            arraySize--;
            btn21.setBackgroundResource(R.drawable.buttonforgroupoff);

        }
    }
    public void btn22Onclick(View view) {
        checkGroupState();
        if (arr[21] == 0) {
            arr[21] = 1;
            temp[21] = 0x16;
            tempControl[21] = 0x16;
            arraySize++;
            btn22.setBackgroundResource(R.drawable.buttonforgroupon);
        } else {
            arr[21] = 0;
            temp[21] = 0;
            tempControl[21] = 0;
            arraySize--;
            btn22.setBackgroundResource(R.drawable.buttonforgroupoff);

        }
    }
    public void btn23Onclick(View view) {
        checkGroupState();
        if (arr[22] == 0) {
            arr[22] = 1;
            temp[22] = 0x17;
            tempControl[22] = 0x17;
            arraySize++;
            btn23.setBackgroundResource(R.drawable.buttonforgroupon);
        } else {
            arr[22] = 0;
            temp[22] = 0;
            tempControl[22] = 0;
            arraySize--;
            btn23.setBackgroundResource(R.drawable.buttonforgroupoff);

        }
    }
    public void btn24Onclick(View view) {
        checkGroupState();
        if (arr[23] == 0) {
            arr[23] = 1;
            temp[23] = 0x18;
            tempControl[23] = 0x18;
            arraySize++;
            btn24.setBackgroundResource(R.drawable.buttonforgroupon);
        } else {
            arr[23] = 0;
            temp[23] = 0;
            tempControl[23] = 0;
            arraySize--;
            btn24.setBackgroundResource(R.drawable.buttonforgroupoff);

        }
    }
    public void btn25Onclick(View view) {
        checkGroupState();
        if (arr[24] == 0) {
            arr[24] = 1;
            temp[24] = 0x19;
            tempControl[24] = 0x19;
            arraySize++;
            btn25.setBackgroundResource(R.drawable.buttonforgroupon);
        } else {
            arr[24] = 0;
            temp[24] = 0;
            tempControl[24] = 0;
            arraySize--;
            btn25.setBackgroundResource(R.drawable.buttonforgroupoff);

        }
    }
    public void btn26Onclick(View view) {
        checkGroupState();
        if (arr[25] == 0) {
            arr[25] = 1;
            temp[25] = 0x1A;
            tempControl[25] = 0x1A;
            arraySize++;
            btn26.setBackgroundResource(R.drawable.buttonforgroupon);
        } else {
            arr[25] = 0;
            temp[25] = 0;
            tempControl[25] = 0;
            arraySize--;
            btn26.setBackgroundResource(R.drawable.buttonforgroupoff);

        }
    }
    public void btn27Onclick(View view) {
        checkGroupState();
        if (arr[26] == 0) {
            arr[26] = 1;
            temp[26] = 0x1B;
            tempControl[26] = 0x1B;
            arraySize++;
            btn27.setBackgroundResource(R.drawable.buttonforgroupon);
        } else {
            arr[26] = 0;
            temp[26] = 0;
            tempControl[26] = 0;
            arraySize--;
            btn27.setBackgroundResource(R.drawable.buttonforgroupoff);

        }
    }
    public void btn28Onclick(View view) {
        checkGroupState();
        if (arr[27] == 0) {
            arr[27] = 1;
            temp[27] = 0x1C;
            tempControl[27] = 0x1C;
            arraySize++;
            btn28.setBackgroundResource(R.drawable.buttonforgroupon);
        } else {
            arr[27] = 0;
            temp[27] = 0;
            tempControl[27] = 0;
            arraySize--;
            btn28.setBackgroundResource(R.drawable.buttonforgroupoff);

        }
    }
    public void btn29Onclick(View view) {
        checkGroupState();
        if (arr[28] == 0) {
            arr[28] = 1;
            temp[28] = 0x1D;
            tempControl[28] = 0x1D;
            arraySize++;
            btn29.setBackgroundResource(R.drawable.buttonforgroupon);
        } else {
            arr[28] = 0;
            temp[28] = 0;
            tempControl[28] = 0;
            arraySize--;
            btn29.setBackgroundResource(R.drawable.buttonforgroupoff);

        }
    }
    public void btn30Onclick(View view) {
        checkGroupState();
        if (arr[29] == 0) {
            arr[29] = 1;
            temp[29] = 0x1E;
            tempControl[29] = 0x1E;
            arraySize++;
            btn30.setBackgroundResource(R.drawable.buttonforgroupon);
        } else {
            arr[29] = 0;
            temp[29] = 0;
            tempControl[29] = 0;
            arraySize--;
            btn30.setBackgroundResource(R.drawable.buttonforgroupoff);

        }
    }
    public void btn31Onclick(View view) {
        checkGroupState();
        if (arr[30] == 0) {
            arr[30] = 1;
            temp[30] = 0x1F;
            tempControl[30] = 0x1F;
            arraySize++;
            btn31.setBackgroundResource(R.drawable.buttonforgroupon);
        } else {
            arr[30] = 0;
            temp[30] = 0;
            tempControl[30] = 0;
            arraySize--;
            btn31.setBackgroundResource(R.drawable.buttonforgroupoff);

        }
    }
    public void btn32Onclick(View view) {
        checkGroupState();
        if (arr[31] == 0) {
            arr[31] = 1;
            temp[31] = 0x20;
            tempControl[31] = 0x20;
            arraySize++;
            btn32.setBackgroundResource(R.drawable.buttonforgroupon);
        } else {
            arr[31] = 0;
            temp[31] = 0;
            tempControl[31] = 0;
            arraySize--;
            btn32.setBackgroundResource(R.drawable.buttonforgroupoff);

        }
    }
    public void btn33Onclick(View view) {
        checkGroupState();
        if (arr[32] == 0) {
            arr[32] = 1;
            temp[32] = 0x21;
            tempControl[32] = 0x21;
            arraySize++;
            btn33.setBackgroundResource(R.drawable.buttonforgroupon);
        } else {
            arr[32] = 0;
            temp[32] = 0;
            tempControl[32] = 0;
            arraySize--;
            btn33.setBackgroundResource(R.drawable.buttonforgroupoff);

        }
    }
    public void btn34Onclick(View view) {
        checkGroupState();
        if (arr[33] == 0) {
            arr[33] = 1;
            temp[33] = 0x22;
            tempControl[33] = 0x22;
            arraySize++;
            btn34.setBackgroundResource(R.drawable.buttonforgroupon);
        } else {
            arr[33] = 0;
            temp[33] = 0;
            tempControl[33] = 0;
            arraySize--;
            btn34.setBackgroundResource(R.drawable.buttonforgroupoff);

        }
    }
    public void btn35Onclick(View view) {
        checkGroupState();
        if (arr[34] == 0) {
            arr[34] = 1;
            temp[34] = 0x23;
            tempControl[34] = 0x23;
            arraySize++;
            btn35.setBackgroundResource(R.drawable.buttonforgroupon);
        } else {
            arr[34] = 0;
            temp[34] = 0;
            tempControl[34] = 0;
            arraySize--;
            btn35.setBackgroundResource(R.drawable.buttonforgroupoff);

        }
    }


    // 옵션 누를때 마다 화면 보여줬다 사라졌다하는거


    public void lampOnclick(View view) {
        lampButton.setBackgroundResource(R.drawable.lightwhite);
        upDownButton.setBackgroundResource(R.drawable.updowngreen);
        option1.setVisibility(View.VISIBLE);
        option2.setVisibility(View.GONE);
        option3.setVisibility(View.GONE);
        option4.setVisibility(View.GONE);
        barForLight.setVisibility(View.VISIBLE);
        barForUpdown.setVisibility(View.GONE);
        barForGroup.setVisibility(View.GONE);


    }

    public void upDownOnclick(View view) {
        lampButton.setBackgroundResource(R.drawable.lightgreen);
        upDownButton.setBackgroundResource(R.drawable.updownwhite);
        option1.setVisibility(View.GONE);
        option2.setVisibility(View.VISIBLE);
        option3.setVisibility(View.GONE);
        option4.setVisibility(View.VISIBLE);
        barForLight.setVisibility(View.GONE);
        barForUpdown.setVisibility(View.VISIBLE);
        barForGroup.setVisibility(View.GONE);
    }


    //전체선택하는거
    public void AllSelectOnclick(View view) {
        btn1.setBackgroundResource(R.drawable.buttonforgroupon);
        btn2.setBackgroundResource(R.drawable.buttonforgroupon);
        btn3.setBackgroundResource(R.drawable.buttonforgroupon);
        btn4.setBackgroundResource(R.drawable.buttonforgroupon);
        btn5.setBackgroundResource(R.drawable.buttonforgroupon);
        btn6.setBackgroundResource(R.drawable.buttonforgroupon);
        btn7.setBackgroundResource(R.drawable.buttonforgroupon);
        btn8.setBackgroundResource(R.drawable.buttonforgroupon);
        btn9.setBackgroundResource(R.drawable.buttonforgroupon);
        btn10.setBackgroundResource(R.drawable.buttonforgroupon);
        btn11.setBackgroundResource(R.drawable.buttonforgroupon);
        btn12.setBackgroundResource(R.drawable.buttonforgroupon);
        btn13.setBackgroundResource(R.drawable.buttonforgroupon);
        btn14.setBackgroundResource(R.drawable.buttonforgroupon);
        btn15.setBackgroundResource(R.drawable.buttonforgroupon);
        btn16.setBackgroundResource(R.drawable.buttonforgroupon);
        btn17.setBackgroundResource(R.drawable.buttonforgroupon);
        btn18.setBackgroundResource(R.drawable.buttonforgroupon);
        btn19.setBackgroundResource(R.drawable.buttonforgroupon);
        btn20.setBackgroundResource(R.drawable.buttonforgroupon);
        btn21.setBackgroundResource(R.drawable.buttonforgroupon);
        btn22.setBackgroundResource(R.drawable.buttonforgroupon);
        btn23.setBackgroundResource(R.drawable.buttonforgroupon);
        btn24.setBackgroundResource(R.drawable.buttonforgroupon);
        btn25.setBackgroundResource(R.drawable.buttonforgroupon);
        btn26.setBackgroundResource(R.drawable.buttonforgroupon);
        btn27.setBackgroundResource(R.drawable.buttonforgroupon);
        btn28.setBackgroundResource(R.drawable.buttonforgroupon);
        btn29.setBackgroundResource(R.drawable.buttonforgroupon);
        btn30.setBackgroundResource(R.drawable.buttonforgroupon);
        btn31.setBackgroundResource(R.drawable.buttonforgroupon);
        btn32.setBackgroundResource(R.drawable.buttonforgroupon);
        btn33.setBackgroundResource(R.drawable.buttonforgroupon);
        btn34.setBackgroundResource(R.drawable.buttonforgroupon);
        btn35.setBackgroundResource(R.drawable.buttonforgroupon);


        for (int i = 0; i < 35; i++) {
            arr[i] = 1;
        }
        arraySize = 35;
        temp[0] = 0x01;
        temp[1] = 0x02;
        temp[2] = 0x03;
        temp[3] = 0x04;
        temp[4] = 0x05;
        temp[5] = 0x06;
        temp[6] = 0x07;
        temp[7] = 0x08;
        temp[8] = 0x09;
        temp[9] = 0xA;
        temp[10] = 0xB;
        temp[11] = 0xC;
        temp[12] = 0xD;
        temp[13] = 0xE;
        temp[14] = 0xF;
        temp[15] = 0x10;
        temp[16] = 0x11;
        temp[17] = 0x12;
        temp[18] = 0x13;
        temp[19] = 0x14;
        temp[20] = 0x15;
        temp[21] = 0x16;
        temp[22] = 0x17;
        temp[23] = 0x18;
        temp[24] = 0x19;
        temp[25] = 0x1A;
        temp[26] = 0x1B;
        temp[27] = 0x1C;
        temp[28] = 0x1D;
        temp[29] = 0x1E;
        temp[30] = 0x1F;
        temp[31] = 0x20;
        temp[32] = 0x21;
        temp[33] = 0x22;
        temp[34] = 0x23;
    }

    public void AllCancelOnclick(View view) {
        btn1.setBackgroundResource(R.drawable.buttonforgroupoff);
        btn2.setBackgroundResource(R.drawable.buttonforgroupoff);
        btn3.setBackgroundResource(R.drawable.buttonforgroupoff);
        btn4.setBackgroundResource(R.drawable.buttonforgroupoff);
        btn5.setBackgroundResource(R.drawable.buttonforgroupoff);
        btn6.setBackgroundResource(R.drawable.buttonforgroupoff);
        btn7.setBackgroundResource(R.drawable.buttonforgroupoff);
        btn8.setBackgroundResource(R.drawable.buttonforgroupoff);
        btn9.setBackgroundResource(R.drawable.buttonforgroupoff);
        btn10.setBackgroundResource(R.drawable.buttonforgroupoff);
        btn11.setBackgroundResource(R.drawable.buttonforgroupoff);
        btn12.setBackgroundResource(R.drawable.buttonforgroupoff);
        btn13.setBackgroundResource(R.drawable.buttonforgroupoff);
        btn14.setBackgroundResource(R.drawable.buttonforgroupoff);
        btn15.setBackgroundResource(R.drawable.buttonforgroupoff);
        btn16.setBackgroundResource(R.drawable.buttonforgroupoff);
        btn17.setBackgroundResource(R.drawable.buttonforgroupoff);
        btn18.setBackgroundResource(R.drawable.buttonforgroupoff);
        btn19.setBackgroundResource(R.drawable.buttonforgroupoff);
        btn20.setBackgroundResource(R.drawable.buttonforgroupoff);
        btn21.setBackgroundResource(R.drawable.buttonforgroupoff);
        btn22.setBackgroundResource(R.drawable.buttonforgroupoff);
        btn23.setBackgroundResource(R.drawable.buttonforgroupoff);
        btn24.setBackgroundResource(R.drawable.buttonforgroupoff);
        btn25.setBackgroundResource(R.drawable.buttonforgroupoff);
        btn26.setBackgroundResource(R.drawable.buttonforgroupoff);
        btn27.setBackgroundResource(R.drawable.buttonforgroupoff);
        btn28.setBackgroundResource(R.drawable.buttonforgroupoff);
        btn29.setBackgroundResource(R.drawable.buttonforgroupoff);
        btn30.setBackgroundResource(R.drawable.buttonforgroupoff);
        btn31.setBackgroundResource(R.drawable.buttonforgroupoff);
        btn32.setBackgroundResource(R.drawable.buttonforgroupoff);
        btn33.setBackgroundResource(R.drawable.buttonforgroupoff);
        btn34.setBackgroundResource(R.drawable.buttonforgroupoff);
        btn35.setBackgroundResource(R.drawable.buttonforgroupoff);
        for (int i = 0; i < 35; i++) {
            arr[i] = 0;
        }
        arraySize = 0;
        temp[0] = 0;
        temp[1] = 0;
        temp[2] = 0;
        temp[3] = 0;
        temp[4] = 0;
        temp[5] = 0;
        temp[6] = 0;
        temp[7] = 0;
        temp[8] = 0;
        temp[9] = 0;
        temp[10] = 0;
        temp[11] = 0;
        temp[12] = 0;
        temp[13] = 0;
        temp[14] = 0;
        temp[15] = 0;
        temp[16] = 0;
        temp[17] = 0;
        temp[18] = 0;
        temp[19] = 0;
        temp[20] = 0;
        temp[21] = 0;
        temp[22] = 0;
        temp[23] = 0;
        temp[24] = 0;
        temp[25] = 0;
        temp[26] = 0;
        temp[27] = 0;
        temp[28] = 0;
        temp[29] = 0;
        temp[30] = 0;
        temp[31] = 0;
        temp[32] = 0;
        temp[33] = 0;
        temp[34] = 0;
    }
    //어떤 그룹에 목록을 넣을건지에 관한 팝업창


    @Override
    protected void onStart() {
        super.onStart();// ATTENTION: This was auto-generated to implement the App Indexing API.
// See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        //블루투스가 꺼져있을때 켜는것
        if (!bluetoothAdapter.isEnabled()) {
            Intent enableIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableIntent, REQUEST_ENABLE_BT);
        }
        setup();
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }


    private void setup() {
        //블루투스 페어링 가능한거 리스트뷰에 올리고 클릭리스너로 메시지 띄우기
        Set<BluetoothDevice> pairedDevices = bluetoothAdapter.getBondedDevices();
        if (pairedDevices.size() > 0) {
            pairedDeviceArrayList = new ArrayList<BluetoothDevice>();
            for (BluetoothDevice device : pairedDevices) {
                pairedDeviceArrayList.add(device);
            }
            pairedDeviceAdapter = new ArrayAdapter<BluetoothDevice>(this, android.R.layout.simple_list_item_1, pairedDeviceArrayList);
            listViewPairedDevice.setAdapter(pairedDeviceAdapter);
            listViewPairedDevice.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    BluetoothDevice device = (BluetoothDevice) parent.getItemAtPosition(position);
                    Toast.makeText(MainActivity.this,
                            "이름 : " + device.getName() + "",
                            Toast.LENGTH_SHORT).show();

                    textStatus.setText("start ThreadConnectBTdevice");
                    myThreadConnectBTdevice = new ThreadConnectBTdevice(device);
                    myThreadConnectBTdevice.start();
                }
            });
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mSerial!=null) {
            mSerial.end();
            mSerial = null;
        }
        if (myThreadConnectBTdevice != null) {
            myThreadConnectBTdevice.cancel();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_ENABLE_BT) {
            if (resultCode == Activity.RESULT_OK) {
                setup();
            } else {
                Toast.makeText(this,
                        "BlueTooth NOT enabled",
                        Toast.LENGTH_SHORT).show();
                finish();
            }
        }
    }

    //Called in ThreadConnectBTdevice once connect successed
    //to start ThreadConnected
    private void startThreadConnected(BluetoothSocket socket) {

        myThreadConnected = new ThreadConnected(socket);
        myThreadConnected.start();
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
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }

    /*
    ThreadConnectBTdevice:
    Background Thread to handle BlueTooth connecting
    */
    private class ThreadConnectBTdevice extends Thread {

        private BluetoothSocket bluetoothSocket = null;
        private final BluetoothDevice bluetoothDevice;


        private ThreadConnectBTdevice(BluetoothDevice device) {
            bluetoothDevice = device;

            try {
                bluetoothSocket = device.createRfcommSocketToServiceRecord(myUUID);
                textStatus.setText("bluetoothSocket: \n" + bluetoothSocket);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            boolean success = false;
            try {
                bluetoothSocket.connect();
                success = true;
            } catch (IOException e) {
                e.printStackTrace();

                final String eMessage = e.getMessage();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        textStatus.setText("something wrong bluetoothSocket.connect(): \n" + eMessage);
                    }
                });

                try {
                    bluetoothSocket.close();
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
            if (success) {
                //connect successful
//                final String msgconnected = "connect successful:\n"
//                        + "BluetoothSocket: " + bluetoothSocket + "\n"
//                        + "BluetoothDevice: " + bluetoothDevice;
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        textStatus.setText("");
                        textByteCnt.setText("");
                        Toast.makeText(MainActivity.this, "Connect", Toast.LENGTH_LONG).show();
                        listViewPairedDevice.setVisibility(View.GONE);
                        inputPane.setVisibility(View.VISIBLE);
                    }
                });
                startThreadConnected(bluetoothSocket);
            } else {
                //fail 블루투스 팅기는거
//                Toast.makeText(MainActivity.this, "Connect fail.", Toast.LENGTH_SHORT).show();
                run();
            }
        }

        public void cancel() {
            Toast.makeText(getApplicationContext(),
                    "close bluetoothSocket",
                    Toast.LENGTH_LONG).show();
            try {
                bluetoothSocket.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    /*
    ThreadConnected:
    Background Thread to handle Bluetooth data communication
    after connected
     */
    private class ThreadConnected extends Thread {
        private final BluetoothSocket connectedBluetoothSocket;
        private final InputStream connectedInputStream;
        private final OutputStream connectedOutputStream;

        public ThreadConnected(BluetoothSocket socket) {
            connectedBluetoothSocket = socket;
            InputStream in = null;
            OutputStream out = null;


            try {
                in = socket.getInputStream();
                out = socket.getOutputStream();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            connectedInputStream = in;
            connectedOutputStream = out;
        }

        @Override
        public void run() {
            byte[] buffer = new byte[1024];
            int bytes;
            int i = 1;
            String strRx = "";
            while (true) {
                try {
                    bytes = connectedInputStream.read(buffer);

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                        }
                    });
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                    final String msgConnectionLost = "Connection lost:\n"
                            + e.getMessage();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            textStatus.setText(msgConnectionLost);
                        }
                    });
                }
            }
        }

        public void write(byte[] buffer) {
            try {
                connectedOutputStream.write(buffer);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        public void cancel() {
            try {
                connectedBluetoothSocket.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public class DBHelper extends SQLiteOpenHelper {


        // DBHelper 생성자로 관리할 DB 이름과 버전 정보를 받음
        public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        // DB를 새로 생성할 때 호출되는 함수
        @Override
        public void onCreate(SQLiteDatabase db) {
            // 새로운 테이블 생성
        /* 이름은 MONEYBOOK이고, 자동으로 값이 증가하는 _id 정수형 기본키 컬럼과
        item 문자열 컬럼, price 정수형 컬럼, create_at 문자열 컬럼으로 구성된 테이블을 생성. */
            db.execSQL("CREATE TABLE bb1a (_id INTEGER PRIMARY KEY AUTOINCREMENT,  title INTEGER, onoff INTEGER, item1 INTEGER, item2 INTEGER, item3 INTEGER, item4 INTEGER, item5 INTEGER, item6 INTEGER, item7 INTEGER, item8 INTEGER, item9 INTEGER, item10 INTEGER, item11 INTEGER, item12 INTEGER, item13 INTEGER, item14 INTEGER, item15 INTEGER, item16 INTEGER, item17 INTEGER, item18 INTEGER, item19 INTEGER, item20 INTEGER, item21 INTEGER, item22 INTEGER, item23 INTEGER, item24 INTEGER, item25 INTEGER, item26 INTEGER, item27 INTEGER, item28 INTEGER, item29 INTEGER, item30 INTEGER, item31 INTEGER, item32 INTEGER, item33 INTEGER, item34 INTEGER, item35 INTEGER);");
        }

        // DB 업그레이드를 위해 버전이 변경될 때 호출되는 함수
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }

        public void insert(int title, int onoff, int item1, int item2, int item3, int item4, int item5, int item6, int item7, int item8, int item9, int item10, int item11, int item12, int item13, int item14, int item15, int item16, int item17, int item18, int item19, int item20, int item21, int item22, int item23, int item24, int item25, int item26, int item27, int item28, int item29, int item30, int item31, int item32, int item33, int item34, int item35) {
            // 읽고 쓰기가 가능하게 DB 열기
            SQLiteDatabase db = getWritableDatabase();
            // DB에 입력한 값으로 행 추가
            db.execSQL("INSERT INTO bb1a VALUES(null, " + title + ", " + onoff + ", " + item1 + ", " + item2 + ", " + item3 + ", " + item4 + ", " + item5 + ", " + item6 + ", " + item7 + ", " + item8 + ", " + item9 + ", " + item10 + ", " + item11 + ", " + item12 + ", " + item13 + ", " + item14 + ", " + item15 + ", " + item16 + ", " + item17 + ", " + item18 + ", " + item19 + ", " + item20 + ", " + item21 + ", " + item22 + ", " + item23 + ", " + item24 + ", " + item25 + ", " + item26 + ", " + item27 + ", " + item28 + ", " + item29 + ", " + item30 + ", " + item31 + ", " + item32 + ", " + item33 + ", " + item34 + ", " + item35 + ");");
            db.close();
        }

        public void searchGroup1() {
            // 읽기가 가능하게 DB 열기
            SQLiteDatabase db = getReadableDatabase();
            // DB에 있는 데이터를 쉽게 처리하기 위해 Cursor를 사용하여 테이블에 있는 모든 데이터 출력
            Cursor cursor = db.rawQuery("SELECT * FROM bb1a where title='11'", null);
            while (cursor.moveToNext()) {
                for (int i = 0; i < 36; i++) {
                    dbgroup1[i] = cursor.getInt(i+2);
                }
            }
        }

        public void searchGroup2() {
            // 읽기가 가능하게 DB 열기
            SQLiteDatabase db = getReadableDatabase();
            // DB에 있는 데이터를 쉽게 처리하기 위해 Cursor를 사용하여 테이블에 있는 모든 데이터 출력
            Cursor cursor = db.rawQuery("SELECT * FROM bb1a where title='22'", null);
            while (cursor.moveToNext()) {
                for (int i = 0; i < 36; i++) {
                    dbgroup2[i] = cursor.getInt(i + 2);
                }
            }
        }

        public void searchGroup3() {
            // 읽기가 가능하게 DB 열기
            SQLiteDatabase db = getReadableDatabase();
            // DB에 있는 데이터를 쉽게 처리하기 위해 Cursor를 사용하여 테이블에 있는 모든 데이터 출력
            Cursor cursor = db.rawQuery("SELECT * FROM bb1a where title='33'", null);
            while (cursor.moveToNext()) {
                for (int i = 0; i < 36; i++) {
                    dbgroup3[i] = cursor.getInt(i + 2);
                }
            }
        }

        public void searchGroup4() {
            // 읽기가 가능하게 DB 열기
            SQLiteDatabase db = getReadableDatabase();
            // DB에 있는 데이터를 쉽게 처리하기 위해 Cursor를 사용하여 테이블에 있는 모든 데이터 출력
            Cursor cursor = db.rawQuery("SELECT * FROM bb1a where title='44'", null);
            while (cursor.moveToNext()) {
                for (int i = 0; i < 36; i++) {
                    dbgroup4[i] = cursor.getInt(i + 2);
                }
            }
        }

        public void searchGroup5() {
            // 읽기가 가능하게 DB 열기
            SQLiteDatabase db = getReadableDatabase();
            // DB에 있는 데이터를 쉽게 처리하기 위해 Cursor를 사용하여 테이블에 있는 모든 데이터 출력
            Cursor cursor = db.rawQuery("SELECT * FROM bb1a where title='55'", null);
            while (cursor.moveToNext()) {
                for (int i = 0; i < 36; i++) {
                    dbgroup5[i] = cursor.getInt(i + 2);
                }
            }
        }

        public void searchGroup6() {
            // 읽기가 가능하게 DB 열기
            SQLiteDatabase db = getReadableDatabase();
            // DB에 있는 데이터를 쉽게 처리하기 위해 Cursor를 사용하여 테이블에 있는 모든 데이터 출력
            Cursor cursor = db.rawQuery("SELECT * FROM bb1a where title='66'", null);
            while (cursor.moveToNext()) {
                for (int i = 0; i < 36; i++) {
                    dbgroup6[i] = cursor.getInt(i + 2);
                }
            }
        }

        public void searchGroup7() {
            // 읽기가 가능하게 DB 열기
            SQLiteDatabase db = getReadableDatabase();
            // DB에 있는 데이터를 쉽게 처리하기 위해 Cursor를 사용하여 테이블에 있는 모든 데이터 출력
            Cursor cursor = db.rawQuery("SELECT * FROM bb1a where title='77'", null);
            while (cursor.moveToNext()) {
                for (int i = 0; i < 36; i++) {
                    dbgroup7[i] = cursor.getInt(i + 2);
                }
            }
        }

        public void searchGroup8() {
            // 읽기가 가능하게 DB 열기
            SQLiteDatabase db = getReadableDatabase();
            // DB에 있는 데이터를 쉽게 처리하기 위해 Cursor를 사용하여 테이블에 있는 모든 데이터 출력
            Cursor cursor = db.rawQuery("SELECT * FROM bb1a where title='88'", null);
            while (cursor.moveToNext()) {
                for (int i = 0; i < 36; i++) {
                    dbgroup8[i] = cursor.getInt(i + 2);
                }
            }
        }

        public void delete(int z) {
            SQLiteDatabase db = getWritableDatabase();
            // 입력한 항목과 일치하는 행 삭제
            db.execSQL("DELETE FROM bb1a WHERE title='"+ z +"';");
            for (int i = 0; i < 36; i++) {
                dbgroup1[i] = 0;
            }
            db.close();
        }
        public void delete2(int z) {
            SQLiteDatabase db = getWritableDatabase();
            // 입력한 항목과 일치하는 행 삭제
            db.execSQL("DELETE FROM bb1a WHERE title='"+ z +"';");
            for (int i = 0; i < 36; i++) {
                dbgroup2[i] = 0;
            }
            db.close();
        }
        public void delete3(int z) {
            SQLiteDatabase db = getWritableDatabase();
            // 입력한 항목과 일치하는 행 삭제
            db.execSQL("DELETE FROM bb1a WHERE title='"+ z +"';");
            for (int i = 0; i < 36; i++) {
                dbgroup3[i] = 0;
            }
            db.close();
        }
        public void delete4(int z) {
            SQLiteDatabase db = getWritableDatabase();
            // 입력한 항목과 일치하는 행 삭제
            db.execSQL("DELETE FROM bb1a WHERE title='"+ z +"';");
            for (int i = 0; i < 36; i++) {
                dbgroup4[i] = 0;
            }
            db.close();
        }
        public void delete5(int z) {
            SQLiteDatabase db = getWritableDatabase();
            // 입력한 항목과 일치하는 행 삭제
            db.execSQL("DELETE FROM bb1a WHERE title='"+ z +"';");
            for (int i = 0; i < 36; i++) {
                dbgroup5[i] = 0;
            }
            db.close();
        }
        public void delete6(int z) {
            SQLiteDatabase db = getWritableDatabase();
            // 입력한 항목과 일치하는 행 삭제
            db.execSQL("DELETE FROM bb1a WHERE title='"+ z +"';");
            for (int i = 0; i < 36; i++) {
                dbgroup6[i] = 0;
            }
            db.close();
        }
        public void delete7(int z) {
            SQLiteDatabase db = getWritableDatabase();
            // 입력한 항목과 일치하는 행 삭제
            db.execSQL("DELETE FROM bb1a WHERE title='"+ z +"';");
            for (int i = 0; i < 36; i++) {
                dbgroup7[i] = 0;
            }
            db.close();
        }
        public void delete8(int z) {
            SQLiteDatabase db = getWritableDatabase();
            // 입력한 항목과 일치하는 행 삭제
            db.execSQL("DELETE FROM bb1a WHERE title='"+ z +"';");
            for (int i = 0; i < 36; i++) {
                dbgroup8[i] = 0;
            }
            db.close();
        }

    }


}

