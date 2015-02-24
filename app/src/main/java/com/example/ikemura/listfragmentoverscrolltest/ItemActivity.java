package com.example.ikemura.listfragmentoverscrolltest;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

/**
 * Created by ikemurakazutaka on 15/02/23.
 */
public class ItemActivity extends ActionBarActivity implements ItemFragment.OnFragmentInteractionListener {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.item_activity);
		if (savedInstanceState == null) {
			getFragmentManager().beginTransaction().add(R.id.container, ItemFragment.newInstance("item1", "item2")).commit();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// メニューを膨らませる。それが存在する場合、これはアクションバーに項目を追加します。
		getMenuInflater().inflate(R.menu.menu_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// ハンドルアクションバー項目はこちらをクリック。アクションバー意志
		// 自動的に限り、ホーム/上ボタンのクリックを扱う
		// あなたはAndroidManifest.xmlにで親アクティビティを指定するように。
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onFragmentInteraction(String id) {

	}
}
