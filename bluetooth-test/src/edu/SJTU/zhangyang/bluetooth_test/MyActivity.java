package edu.SJTU.zhangyang.bluetooth_test;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        TextView textView1 = (TextView) findViewById(R.id.text1);
        String status = "";
        if (bluetoothAdapter != null) {
            if (!bluetoothAdapter.isEnabled()) {
                bluetoothAdapter.enable();
            }
            String myDeviceAddress = bluetoothAdapter.getAddress();
            String myDeviceName = bluetoothAdapter.getName();
            status = myDeviceName + ": " + myDeviceAddress;
        }
        textView1.setText(textView1.getText() + "\n" + status);
        Toast.makeText(this, status, Toast.LENGTH_LONG).show();
    }
}
