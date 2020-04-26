package com.example.i.lable3;



import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;


public class SimpleAdapterTutorial extends Activity {
String name[]={"Lion","Tiger","Monkey","Dog","Cat","Elephant"};
 int images[]={R.drawable.lion,R.drawable.tiger,R.drawable.monkey,R.drawable.dog,R.drawable.cat,R.drawable.elephant};
 ListView simpleListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simpleadapter);
        simpleListView=findViewById(R.id.simpleListView);
        ArrayList<HashMap<String,String>> arrayList=new ArrayList<>();
        for(int i=0;i<name.length;i++){
            HashMap<String,String> hashMap=new HashMap<>();
            hashMap.put("name",name[i]);
            hashMap.put("image",images[i]+"");
            arrayList.add(hashMap);
        }
        String from[] ={"name","image"};
        int to[]={R.id.textview,R.id.imageView};
        SimpleAdapter simpleAdapter=new SimpleAdapter(this,arrayList,R.layout.listview,from,to);
        simpleListView.setAdapter(simpleAdapter);

        simpleListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(),name[i],Toast.LENGTH_LONG).show();
            }
        });

    }
}