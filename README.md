# Micronaut Demo

Investigation of using interfaces, classes and subtypes in micronaut for
https://github.com/micronaut-projects/micronaut-core/issues/747

## Installation

Install and run a docker consul image

    docker run -p 8500:8500 consul

Build project and run it

    ./gradlew build
    
    # in first tab:
    ./gradlew :gateway:run
    
    # in second tab:
    ./gradlew :product-catalogue:run

## Testing both service and gateway

Run the shell script to perform all cases.

    sh ./go.sh

## Testing comments - Service

    # all working as expected

    $ curl http://localhost:9001/pc/flowableListOfTypeProductInterface
    [[{"id":"pflfi-1","name":"pflfi-1 name"}]]

    $ curl http://localhost:9001/pc/singleOfTypeProductInterface/1
    {"id":"sfpi-p1","name":"sfpi-p1 name"}
    
    $ curl http://localhost:9001/pc/singleOfProductDataClass/1
    {"id":"sfpdc-p1","name":"sfpdc-p1 name"}
    
    $ curl http://localhost:9001/pc/singleOfProductOpen/1
    {"id":"sfpo-p1","name":"sfpo-p1 name"}
    
    $ curl http://localhost:9001/pc/singleOfProductWithDesc/1
    {"desc":"sfpwd-p1 desc","id":"sfpwd-p1","name":"sfpwd-p1 name"}
    
    $ curl http://localhost:9001/pc/singleListOfProductThatWillBeSubtype
    [{"desc":"sflpo-p1 desc","id":"sflpo-p1","name":"sflpo-p1 name"}]
    
## Testing comments - Gateway

    # more brackets than i expect (flowables of flowables?) but not using Fallback   
    $ curl http://localhost:9000/flowableListOfTypeProductInterface
    [[[{"id":"pflfi-1","name":"pflfi-1 name"}]]]

    # uses fallback as it's an interface not class?
    $ curl http://localhost:9000/singleOfTypeProductInterface/1
    {"id":"sfpi-p1-FB","name":"sfpi-p1-FB name"}
    
    # works, because data class not interface?
    $ curl http://localhost:9000/singleOfProductDataClass/1
    {"id":"sfpdc-p1","name":"sfpdc-p1 name"}
    
    # works, because open class?
    $ curl http://localhost:9000/singleOfProductOpen/1
    {"id":"sfpo-p1","name":"sfpo-p1 name"}
    
    # uses fallback - unknown why
    $ curl http://localhost:9000/singleOfProductWithDesc/1
    {"desc":"sfpwd-p1-FB desc","id":"sfpwd-p1-FB","name":"sfpwd-p1-FB name"}

    # doesn't return desc value of subtype
    $ curl http://localhost:9000/singleListOfProductThatWillBeSubtype
    [{"id":"sflpo-p1","name":"sflpo-p1 name"}]