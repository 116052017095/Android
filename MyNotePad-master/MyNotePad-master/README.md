
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

### 代码解读

### 结果图
