#!/bin/bash
basepath=$(cd `dirname $0`; pwd)
parentpath=$(cd ../..; pwd)

protoc -I=$parentpath/protoFile --go_out=plugins=grpc:$parentpath/go/proto $parentpath/protoFile/proto.proto
