package com.example.nativo
import io.flutter.plugin.common.MethodChannel
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine

    class MainActivity : FlutterActivity() {

        private val channel = "coderia.dev.br/nativo"

        override fun configureFlutterEngine(flutterEngine: FlutterEngine) {
            super.configureFlutterEngine(flutterEngine)
            MethodChannel(flutterEngine.dartExecutor.binaryMessenger,channel).setMethodCallHandler {
                call,result ->

                if(call.method  == "calcSum") {
                    val a = call.argument<Int>("a")?.toInt() ?:  0
                    val b = call.argument<Int>("b")?.toInt() ?:  0
                    result.success( a + b)
                } else {
                    result.notImplemented()
                }
            }
        }
    }
