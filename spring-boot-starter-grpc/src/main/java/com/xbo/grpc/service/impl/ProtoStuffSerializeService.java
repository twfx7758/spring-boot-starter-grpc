package com.xbo.grpc.service.impl;

import com.xbo.grpc.service.SerializeService;
import com.xbo.grpc.service.GrpcRequest;
import com.xbo.grpc.service.GrpcResponse;
import com.xbo.grpc.util.ProtobufUtils;
import com.xbo.rpc.GrpcService;
import com.google.protobuf.ByteString;

/**
 * ProtoStuff 序列化/反序列化工具
 */
public class ProtoStuffSerializeService implements SerializeService {

    @Override
    public GrpcRequest deserialize(GrpcService.Request request) {
        return ProtobufUtils.deserialize(request.getRequest().toByteArray(), GrpcRequest.class);
    }

    @Override
    public GrpcResponse deserialize(GrpcService.Response response) {
        return ProtobufUtils.deserialize(response.getResponse().toByteArray(), GrpcResponse.class);
    }

    @Override
    public ByteString serialize(GrpcResponse response) {
        return ByteString.copyFrom(ProtobufUtils.serialize(response));
    }

    @Override
    public ByteString serialize(GrpcRequest request) {
        return  ByteString.copyFrom(ProtobufUtils.serialize(request));
    }

}
