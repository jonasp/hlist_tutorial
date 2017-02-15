#!/bin/sh
./coursier launch -q -P \
  com.lihaoyi:ammonite_2.11.8:0.8.2 \
  com.chuusai:shapeless_2.11:2.3.2
  # -- --predef 'import shapeless._' < /dev/tty
