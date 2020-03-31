#!/bin/bash

keytool -genkeypair \
  -alias oauth-jwt \
  -keyalg RSA \
  -keypass password \
  -keystore keystore.jks \
  -storepass password