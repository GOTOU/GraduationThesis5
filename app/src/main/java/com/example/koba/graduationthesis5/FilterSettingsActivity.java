package com.example.koba.graduationthesis5;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AlertDialog.Builder;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class FilterSettingsActivity extends AppCompatActivity {

    private ListView listView = null;
    private Button button = null;
    private ArrayAdapter<String> adapter = null;
    private SearchView addView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter_settings);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //What to do on back clicked
                Intent intent = new Intent(FilterSettingsActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });


        listView = (ListView)findViewById(R.id.listView);

        ListStock listStock = new ListStock();
/*        String[] temp = (String[]) listStock.getList().toArray(new String[]{}); //ListStockクラスからListをとってきている

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1, temp);  //これやると強制終了する
        listView.setAdapter(adapter);
*/
        List<String> dataList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1, listStock.getList());
        listView.setAdapter(adapter);

        //Listviewのアイテムを選択した時の動作
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });


        //Listviewのアイテムを長押しした時の動作
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                ListView list = (ListView)parent;
                String selectedItem = (String)list.getItemAtPosition(position);

                showDialogFragment(selectedItem);
                return false;
            }
        });

/*
        button = (Button)findViewById(R.id.add_list_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText editText = (EditText)findViewById(R.id.edit_text);
                String entry = editText.getText().toString();

                if (entry == ""){
                    Log.d("Debug", "Entry is empty");
                } else {
                    ListStock listStock = new ListStock();
                    listStock.addList(entry);
                    adapter.notifyDataSetChanged();
                    adapter.add(entry);
                }

                //ボタン押した後の文字列の削除
                editText.setText("");
            }
        });
*/
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_filter_settings, menu);
        MenuItem menuItem = menu.findItem(R.id.addView);

        //SearchViewを取得する
        addView = (SearchView) MenuItemCompat.getActionView(menuItem);
        addView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                if (query == ""){
                    Log.d("Debug", "Entry is empty");
                } else {
                    ListStock listStock = new ListStock();
                    listStock.addList(query);
                    adapter.clear();
                    adapter.addAll(listStock.getRenewalList());
                    adapter.notifyDataSetChanged();

//                    adapter.add(query);
                }

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        return true;
    }


    //ListViewアイテムにエントリを追加するメソッド
    private void addListData(String entry){
        ListStock listStock = new ListStock();
        listStock.getList().add(entry);
    }


    //FragmentManagerでDialogを管理するメソッド
    private void showDialogFragment(String selectedItem){
        FragmentManager manager = getSupportFragmentManager(); //問題が起こるかも
        DeliteDialog dialog = new DeliteDialog();
        dialog.setSelectedItem(selectedItem);

        dialog.show(manager, "Dialog");

    }


    public static class DeliteDialog extends DialogFragment{

        private String selectedItem = null;


        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState){
            Log.d("Debug", "onCreateDialog");

            Builder builder = new AlertDialog.Builder(getActivity());
            builder.setTitle("Delite entry");
            builder.setMessage("Are you really?");


            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                    FilterSettingsActivity activity = (FilterSettingsActivity)getActivity();
                    activity.removeItem(selectedItem);
                }
            });
            AlertDialog dialog = builder.create(); //ここ問題おきるかも
            return dialog;
        }


        public void setSelectedItem(String selectedItem){
            Log.d("Debug", "setSelectedItem");
            this.selectedItem = selectedItem;
        }

    }


    protected void removeItem(String selectedItem){
        Log.d("Debug", "removeItem");
        adapter.remove(selectedItem);
    }
}

