package com.tomshley.brands.global.tware.tech.product.paste.common.models

import com.tomshley.brands.global.tware.tech.product.paste.common.marshalling.PasteMarshallModel
//import upickle.implicits.*
//import upickle.core.*
//import upickle.default.*

import java.io.File
import java.nio.file.Path


case class SimpleModel(
                        path: String,
                        buildDirPath: String,
                        myFile: File,
                        myPath: Path,
                        eTest: SupportedPasteAssetType,
                        myOpt: Option[String] = None
                      ) extends PasteMarshallModel[SimpleModel] {
}


//case class Dog(name: String, age: Int) derives ReadWriter
//
//sealed trait Animal[T] extends MarshallModel[Animal[T]] derives ReadWriter
//
//case class Person(name: String, address: String, age: Int = 20) extends Animal[Person]
//
//case class Cat(name: String, owner: Person) extends Animal[Cat]

enum SimpleEnum2 extends Enum[SimpleEnum2]:
  case A, B
end SimpleEnum2

enum SimpleEnum3 extends Enum[SimpleEnum3]:
  case A, B
end SimpleEnum3

//enum SimpleEnum derives ReadWriter:
//  case A, B
//
//enum ColorEnum(val rgb: Int) derives ReadWriter:
//  case Red extends ColorEnum(0xFF0000)
//  case Green extends ColorEnum(0x00FF00)
//  case Blue extends ColorEnum(0x0000FF)
//  case Mix(mix: Int) extends ColorEnum(mix)
//  case Unknown(mix: Int) extends ColorEnum(0x000000)
