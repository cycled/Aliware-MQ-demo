package com.alibaba.ons.message.example.producer;

import com.aliyun.openservices.ons.api.Message;
import com.aliyun.openservices.ons.api.transaction.LocalTransactionChecker;
import com.aliyun.openservices.ons.api.transaction.TransactionStatus;

/**
 * Created by jixiang.jjx on 2014/10/15.
 */
public class LocalTransactionCheckerImpl implements LocalTransactionChecker {

    /**
     * 本地事务Checker,详见: https://help.aliyun.com/document_detail/29548.html?spm=5176.doc35104.6.133.pJkthu
     */
    public TransactionStatus check(Message msg) {
        System.out.println("收到事务消息的回查请求, MsgId: " + msg.getMsgID());
        return TransactionStatus.CommitTransaction;
    }
}
