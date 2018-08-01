# flutter 学习记录
### 入口
其中 main.dart文件为整个程序的入口

### 外部package引用
pubspec.yaml文件管理

实例：添加english_words

1. 首先在pubspec.yaml文件中添加english_words和版本号添加到依赖中


    dependencies:
      flutter:
        sdk: flutter
      cupertino_icons: ^0.1.0
      english_words: ^3.1.0
      
2. 保存之后AS中会出现安装提示框，安装等待成功

3. 在main.dart文件中的最上面引入，Android studio会有提示。当然，如果你在下面
没有使用该package，这里在展示上会有些许不同。

4. 对main.dart内容做一定修改，增加内容如下


    import 'package:flutter/material.dart';
    import 'package:english_words/english_words.dart';
    
    void main() => runApp(new MyApp());
    
    class MyApp extends StatelessWidget {
      @override
      Widget build(BuildContext context) {
        final wordPair = new WordPair.random();  // 新增
        return new MaterialApp(
          title: 'Welcome to Flutter',
          home: new Scaffold(
            appBar: new AppBar(
              title: new Text('Welcome to Flutter'),
            ),
            body: new Center(
    //          child: new Text('Hello World'),
              child: new Text(wordPair.asPascalCase),  // 新增
            ),
          ),
        );
      }
    }
    
    
    
### assert
注意缩进，需要添加图片资源的相对路径

      # To add assets to your application, add an assets section, like this:
      # assets:
      #  - images/a_dot_burr.jpeg
      #  - images/a_dot_ham.jpeg

### layout 相关

flutter中layout核心就是widget。
常用widget：

* Container 

      Container({
        Key key,
        this.alignment,
        this.padding,
        Color color,
        Decoration decoration,
        this.foregroundDecoration,
        double width,
        double height,
        BoxConstraints constraints,
        this.margin,
        this.transform,
      })
    
* Row
横向容器
* Column
纵向容器

##### 水平和垂直方向的layout

* 水平布局


    class LayoutImagesH {
      static layoutImagesH() {
        MaterialApp material = new MaterialApp(
          home: new Scaffold(
            appBar: new AppBar(
              title: new Text(
                "Images H Layout",
                style: new TextStyle(color: Colors.white, fontSize: 20.0),
              ),
            ),
            body: _getLayoutContainer(),
          ),
        );
        return material;
      }
    
      static _getLayoutContainer() {
        Row row = new Row(
          mainAxisAlignment: MainAxisAlignment.spaceEvenly,
          crossAxisAlignment: CrossAxisAlignment.center,
          children: <Widget>[
            _getRowsImage('images/pic1.jpg'),
            _getRowsImage('images/pic2.jpg'),
            _getRowsImage('images/pic3.jpg')
          ],
        );
        Container container = new Container(
          padding: const EdgeInsets.all(15.0),
          color: Colors.grey,
          child: row,
        );
        return container;
      }
    
      static _getRowsImage(imageStr) {
        return new Image.asset(
          imageStr,
          width: 100.0,
        );
      }
    }
   
 

