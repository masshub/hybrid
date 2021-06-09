import 'package:flutter/cupertino.dart';
import 'package:flutter/services.dart';
import 'package:flutter_module/page_1.dart';
import 'package:flutter_module/page_2.dart';
import 'package:flutter_module/page_3.dart';

///
/// description:
///
///

class BasicMessageTool {
  static const BasicMessageChannel messageChannel = const BasicMessageChannel(
      "com.hybrid.message.channel", StandardMessageCodec());

  static Future<dynamic> sendMessage(Object message) async {
    dynamic result = await messageChannel.send(message);
    print("**********$result");
    return result;
  }

  // static Future<Widget> jumpToTargetPage() async {
  //   messageChannel.setMessageHandler((message) async {
  //     String page = message["page"];
  //     print("page:$page");
  //     if ("page1" == page) {
  //       return Page1();
  //     } else if ("page2" == page) {
  //       return Page2();
  //     } else if ("page3" == page) {
  //       return Page3();
  //     }
  //   });
  //   return Center();
  // }
}
