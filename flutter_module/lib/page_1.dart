import 'package:flutter/material.dart';

///
/// description:
/// 
class Page1 extends StatefulWidget {
  const Page1({Key? key}) : super(key: key);

  @override
  _Page1State createState() => _Page1State();
}

class _Page1State extends State<Page1> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text("flutter page"),),
      body: Center(
        child: Text("Page1",style: TextStyle(fontSize: 32.0,color: Colors.blue),),
      ),
    );
  }
}



