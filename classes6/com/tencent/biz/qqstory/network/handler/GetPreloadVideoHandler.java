package com.tencent.biz.qqstory.network.handler;

import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.network.request.GetPreloadVideoListRequest;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.List;

public class GetPreloadVideoHandler
  implements CmdTaskManger.CommandCallback
{
  public static final int a = 0;
  public static final int b = 1;
  public static final int c = 2;
  public static final int d = 3;
  
  public GetPreloadVideoHandler()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, List paramList1, List paramList2)
  {
    GetPreloadVideoListRequest localGetPreloadVideoListRequest = new GetPreloadVideoListRequest();
    localGetPreloadVideoListRequest.jdField_a_of_type_Int = paramInt;
    localGetPreloadVideoListRequest.jdField_a_of_type_JavaUtilList = paramList1;
    localGetPreloadVideoListRequest.b = paramList2;
    CmdTaskManger.a().a(localGetPreloadVideoListRequest, this);
  }
  
  /* Error */
  public void a(GetPreloadVideoListRequest paramGetPreloadVideoListRequest, com.tencent.biz.qqstory.network.response.GetPreloadVideoListResponse paramGetPreloadVideoListResponse, com.tencent.biz.qqstory.base.ErrorMessage paramErrorMessage)
  {
    // Byte code:
    //   0: new 53	com/tencent/biz/qqstory/network/handler/GetPreloadVideoHandler$GetPreloadVideoEvent
    //   3: dup
    //   4: invokespecial 54	com/tencent/biz/qqstory/network/handler/GetPreloadVideoHandler$GetPreloadVideoEvent:<init>	()V
    //   7: astore 4
    //   9: aload 4
    //   11: aload_3
    //   12: putfield 57	com/tencent/biz/qqstory/network/handler/GetPreloadVideoHandler$GetPreloadVideoEvent:jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage	Lcom/tencent/biz/qqstory/base/ErrorMessage;
    //   15: aload_2
    //   16: ifnull +10 -> 26
    //   19: aload_3
    //   20: invokevirtual 63	com/tencent/biz/qqstory/base/ErrorMessage:isFail	()Z
    //   23: ifeq +14 -> 37
    //   26: invokestatic 69	com/tribe/async/dispatch/Dispatchers:get	()Lcom/tribe/async/dispatch/Dispatcher;
    //   29: aload 4
    //   31: invokeinterface 75 2 0
    //   36: return
    //   37: iconst_5
    //   38: invokestatic 80	com/tencent/biz/qqstory/model/SuperManager:a	(I)Lcom/tencent/biz/qqstory/model/IManager;
    //   41: checkcast 82	com/tencent/biz/qqstory/model/StoryManager
    //   44: astore_3
    //   45: aload_1
    //   46: getfield 32	com/tencent/biz/qqstory/network/request/GetPreloadVideoListRequest:jdField_a_of_type_Int	I
    //   49: tableswitch	default:+27->76, 0:+65->114, 1:+75->124, 2:+85->134
    //   76: aload 4
    //   78: aload_1
    //   79: getfield 32	com/tencent/biz/qqstory/network/request/GetPreloadVideoListRequest:jdField_a_of_type_Int	I
    //   82: putfield 83	com/tencent/biz/qqstory/network/handler/GetPreloadVideoHandler$GetPreloadVideoEvent:jdField_a_of_type_Int	I
    //   85: aload 4
    //   87: aload_2
    //   88: getfield 86	com/tencent/biz/qqstory/network/response/GetPreloadVideoListResponse:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   91: putfield 87	com/tencent/biz/qqstory/network/handler/GetPreloadVideoHandler$GetPreloadVideoEvent:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   94: aload 4
    //   96: aload_2
    //   97: getfield 89	com/tencent/biz/qqstory/network/response/GetPreloadVideoListResponse:b	Ljava/util/Map;
    //   100: putfield 90	com/tencent/biz/qqstory/network/handler/GetPreloadVideoHandler$GetPreloadVideoEvent:b	Ljava/util/Map;
    //   103: invokestatic 69	com/tribe/async/dispatch/Dispatchers:get	()Lcom/tribe/async/dispatch/Dispatcher;
    //   106: aload 4
    //   108: invokeinterface 75 2 0
    //   113: return
    //   114: aload_2
    //   115: getfield 86	com/tencent/biz/qqstory/network/response/GetPreloadVideoListResponse:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   118: ifnonnull -42 -> 76
    //   121: goto -45 -> 76
    //   124: aload_2
    //   125: getfield 86	com/tencent/biz/qqstory/network/response/GetPreloadVideoListResponse:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   128: ifnonnull -52 -> 76
    //   131: goto -55 -> 76
    //   134: aload_2
    //   135: getfield 86	com/tencent/biz/qqstory/network/response/GetPreloadVideoListResponse:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   138: ifnonnull -62 -> 76
    //   141: goto -65 -> 76
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	144	0	this	GetPreloadVideoHandler
    //   0	144	1	paramGetPreloadVideoListRequest	GetPreloadVideoListRequest
    //   0	144	2	paramGetPreloadVideoListResponse	com.tencent.biz.qqstory.network.response.GetPreloadVideoListResponse
    //   0	144	3	paramErrorMessage	com.tencent.biz.qqstory.base.ErrorMessage
    //   7	100	4	localGetPreloadVideoEvent	GetPreloadVideoHandler.GetPreloadVideoEvent
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\network\handler\GetPreloadVideoHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */