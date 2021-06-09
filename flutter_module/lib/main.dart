
import 'package:flutter/material.dart';
import 'package:flutter_module/page_1.dart';
import 'package:flutter_module/page_2.dart';
import 'package:flutter_module/page_3.dart';

import 'basic_message_tool.dart';

void main() => runApp(MyApp());

class MyApp extends StatefulWidget {
  @override
  _MyAppState createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  Widget target = Container();

  @override
  void initState() {
    super.initState();
    BasicMessageTool.messageChannel.setMessageHandler((message) async{
      String page = message["page"];
      print("page:$page");
      if ("page1" == page) {
        target = Page1();
      } else if ("page2" == page) {
        target = Page2();
      } else if ("page3" == page) {
        target = Page3();
      }
        setState(() {

        });
    });



  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter page',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: target,
    );
  }
}

class MyHomePage extends StatefulWidget {
  MyHomePage({Key? key, required this.title}) : super(key: key);

  final String title;

  @override
  _MyHomePageState createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {

  Widget target = Container();
  // late Widget target;

  @override
  void initState() {
    super.initState();

  }


  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Colors.white,
      // body: BasicMessageTool.jumpToTargetPage(),
    );
  }
}
