package com.krwnleo.powerbutton;

import android.os.Bundle;
import android.os.PowerManager;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.WindowManager;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Dialog alertDialog = new AlertDialog.Builder(this).   
				setTitle(R.string.title).
                setMessage(R.string.message).   
                setIcon(R.drawable.ic_launcher).   
                setPositiveButton(R.string.reboot, new DialogInterface.OnClickListener() {   

                    @Override   
                    public void onClick(DialogInterface dialog, int which) {   
                       PowerManager pm=(PowerManager) getSystemService(Context.POWER_SERVICE);
                       pm.reboot(null);
                    }   
                }).   
                setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {   

                    @Override   
                    public void onClick(DialogInterface dialog, int which) {   
                        int pid=android.os.Process.myPid();
                        android.os.Process.killProcess(pid);
                    }   
                }).   
                setNeutralButton(R.string.shutdown, new DialogInterface.OnClickListener() {   

                    @Override   
                    public void onClick(DialogInterface dialog, int which) {   
                    	startActivity(new Intent(Intent.ACTION_REQUEST_SHUTDOWN)
                    	.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    	.putExtra(Intent.EXTRA_KEY_CONFIRM, false));    
                    }   
                }).   
                create(); 

        alertDialog.show(); 
	}

	
}
