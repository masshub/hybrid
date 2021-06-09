import 'package:flutter/material.dart';

///
/// description:
/// 
class Page3 extends StatefulWidget {
  const Page3({Key? key}) : super(key: key);

  @override
  _Page3State createState() => _Page3State();
}

class _Page3State extends State<Page3> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text("flutter page"),),
      body: Center(
        child: Text("Page3",style: TextStyle(fontSize: 32.0,color: Colors.blue),),
      ),
    );
  }
}



