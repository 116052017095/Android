
# 笔记本

## 主页

### 代码解读

### 结果图

## 编辑笔记

### 代码解读

### 结果图

## 时间戳

时间戳是显示文本的何时创建的时间

### 代码解读

代码思路是首先将noteslist_item的布局设置成线性布局，在text1底下增加新控件text2

```


    <TextView
        android:id="@+id/time"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:textAppearance="?android:attr/textAppearanceLarge"
        android:gravity="center_vertical"
        android:paddingLeft="10dip"
        android:singleLine="true"
        android:layout_weight="1"
        android:layout_margin="0dp"
        />
        
        
```

然后是将时间格式化

```

        Date Time = new Date(System.currentTimeMillis());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = simpleDateFormat.format(Time);

```

将格式化后的时间存到数据库

```
values.put(NotePad.Notes.COLUMN_NAME_MODIFICATION_DATE, date);

```

在project中增加对时间的描述

```
private static final String[] PROJECTION = new String[] {
            NotePad.Notes._ID, // 0
            NotePad.Notes.COLUMN_NAME_TITLE, // 1
            NotePad.Notes.COLUMN_NAME_MODIFICATION_DATE,
    };

```

接着对私有变量dataColumns与viewIDs增加对时间的描述

```
 private String[] dataColumns = { NotePad.Notes.COLUMN_NAME_TITLE ,NotePad.Notes.COLUMN_NAME_MODIFICATION_DATE} ;
 private String[] dataColumns = { NotePad.Notes.COLUMN_NAME_TITLE ,NotePad.Notes.COLUMN_NAME_MODIFICATION_DATE} ;


```

### 结果图

## 查询功能

查询功能使用的是v7自动的搜索控件，不需要按钮输入就可查询，查询的是使用模糊搜索

### 代码解读

首先将布局改成listview布局,增加了搜索栏

```

<?xml version="1.0" encoding="utf-8"?>
<LinearLayout
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    xmlns:android="http://schemas.android.com/apk/res/android">

    <android.support.v7.widget.SearchView
        android:id="@+id/searchview"
        android:layout_width="match_parent"
        android:layout_height="wrap_content">

    </android.support.v7.widget.SearchView>

    <ListView
        android:id="@+id/searchviewtext"
        android:layout_width="match_parent"
        android:layout_height="match_parent"/>
</LinearLayout>


```

接着我弄了searchnote函数,调用searchview控件

```

 searchView=findViewById(R.id.searchview);
 
 ```
 
 重写了onQueryTextChange，假如输入框的内容等于空就显示全部，否则显示与输入的内容有关的标题
 
 ```
 
  public boolean onQueryTextChange(String text) {
                if(text.equals("")){

                            updatecursor = getContentResolver().query(
                                    getIntent().getData(),
                                    PROJECTION,
                                    null,
                                    null,
                                    NotePad.Notes.DEFAULT_SORT_ORDER
                    );

                }
               else {
                    updatecursor = getContentResolver().query(
                            getIntent().getData(),
                            PROJECTION,
                            NotePad.Notes.COLUMN_NAME_TITLE+" GLOB '*"+text+"*'",
                            null,
                            NotePad.Notes.DEFAULT_SORT_ORDER
                    );
                }
                
```

### 结果图
