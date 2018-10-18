#!/usr/bin/env bash

function curlWithCR {
  echo "Fetching $*"
  curl $*
  echo ""
}

echo "Testing service directly"
curlWithCR http://localhost:9001/pc/flowableListOfTypeProductInterface
curlWithCR http://localhost:9001/pc/singleOfTypeProductInterface/1
curlWithCR http://localhost:9001/pc/singleOfProductDataClass/1
curlWithCR http://localhost:9001/pc/singleOfProductOpen/1
curlWithCR http://localhost:9001/pc/singleOfProductWithDesc/1
curlWithCR http://localhost:9001/pc/singleListOfProductThatWillBeSubtype

echo "Testing gateway"
curlWithCR http://localhost:9000/flowableListOfTypeProductInterface
curlWithCR http://localhost:9000/singleOfTypeProductInterface/1
curlWithCR http://localhost:9000/singleOfProductDataClass/1
curlWithCR http://localhost:9000/singleOfProductOpen/1
curlWithCR http://localhost:9000/singleOfProductWithDesc/1
curlWithCR http://localhost:9000/singleListOfProductThatWillBeSubtype
