# 事件交互和state管理
部分widget都是有状态的stateful ,另外widget是无状态的stateless

继承自StatefulWidget的有Checkbox、Radio、Slider、Form等，这些Widget用户都是可以做一些交互的
,同样的继承自StatelessWidget的Widget有Text、Icon等。

**有状态和无状态的主要区别在于：有状态的Widget在其内部都有一个state用来标记是否发生了变化，
然后调用setState()方法来更新自己。**

### 创建Stateful widget
关键点：
* 需要两个类，StatefulWidget 和State
* State对象包含了widget的state和build()方法
* 当widget的state发生变化时，state对象会调用setState 方法，告诉框架重绘widget

例如demo中英文描述

    // This call to setState tells the Flutter framework that something has
      // changed in this State, which causes it to rerun the build method below
      // so that the display can reflect the updated values. If we changed
      // _counter without calling setState(), then the build method would not be
      // called again, and so nothing would appear to happen.
      

实例代码

       class XXWidget extends StatefulWidget{
            State<StatefulWidget> createState => new _XXState();
       }
       class _XXState extends State{
            Widget build(BuildContext context){
                 return null;
            }
       }
       

### 事件交互实例
        
        Widget build(){
            return new GestureDetector(
                 onTap: _handleTap, // 此处可以给定点击方法
                 child: new Container( // 此处给定点击方法包含的子控件
                 )
            
            );
        
        }
        

