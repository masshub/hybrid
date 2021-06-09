import 'dart:io';

import 'package:flutter/material.dart';

import 'basic_message_tool.dart';

///
/// description:
///
class Page2 extends StatefulWidget {
  const Page2({Key? key}) : super(key: key);

  @override
  _Page2State createState() => _Page2State();
}

class _Page2State extends State<Page2> {
  String imageUrl = "";

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text("flutter page"),),
      body: Container(
        alignment: Alignment.center,
        child: Column(
          children: [
            InkWell(
                onTap: () async {
                  imageUrl =
                      await BasicMessageTool.sendMessage({"type": "camera"});
                  setState(() {});
                },
                child: Text(
                  "page2",
                  style: TextStyle(fontSize: 32.0, color: Colors.blue),
                )),
            imageUrl.isEmpty ? Container() : Image.file(File(imageUrl)),
          ],
        ),
      ),
    );
  }
}
