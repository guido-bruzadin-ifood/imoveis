package br.com.tribotech.imoveis;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class SplashScreen extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.splashscreen);

		TextView version = (TextView)findViewById(R.id.version);
		version.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/orbitron-medium.otf"));
		String strVersionName = "";
		try {
			PackageInfo packageInfo = getPackageManager().getPackageInfo(getPackageName(),0);
			//String strVersionCode = "Version Code: "+ String.valueOf(packageInfo.versionCode);
			strVersionName = "Ver. "+packageInfo.versionName;
		} catch (NameNotFoundException e) {
			e.printStackTrace();
		}
		version.setText(strVersionName);

		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {

				startApp();

			}

		}, 1500);

	}

	private void startApp() {
		Intent intent = new Intent(this, Main.class);
		finish();
		startActivity(intent);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		return false;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		return false;
	}

}
