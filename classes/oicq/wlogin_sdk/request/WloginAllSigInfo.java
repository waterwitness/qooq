package oicq.wlogin_sdk.request;

import java.io.Serializable;
import java.util.TreeMap;
import oicq.wlogin_sdk.sharemem.WloginSigInfo;
import oicq.wlogin_sdk.sharemem.WloginSimpleInfo;

public class WloginAllSigInfo
  implements Serializable, Cloneable
{
  private static final long serialVersionUID = 1L;
  public TreeMap<Long, WloginSigInfo> _tk_map = new TreeMap();
  public long _uin = 0L;
  public WloginSimpleInfo _useInfo = new WloginSimpleInfo();
  public int mainSigMap;
  
  /* Error */
  public WloginAllSigInfo get_clone()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 45	java/lang/Object:clone	()Ljava/lang/Object;
    //   4: checkcast 2	oicq/wlogin_sdk/request/WloginAllSigInfo
    //   7: astore_2
    //   8: aload_2
    //   9: astore_1
    //   10: aload_0
    //   11: getfield 34	oicq/wlogin_sdk/request/WloginAllSigInfo:_tk_map	Ljava/util/TreeMap;
    //   14: ifnull +77 -> 91
    //   17: aload_0
    //   18: getfield 34	oicq/wlogin_sdk/request/WloginAllSigInfo:_tk_map	Ljava/util/TreeMap;
    //   21: invokevirtual 49	java/util/TreeMap:keySet	()Ljava/util/Set;
    //   24: invokeinterface 55 1 0
    //   29: astore_3
    //   30: aload_2
    //   31: astore_1
    //   32: aload_3
    //   33: invokeinterface 61 1 0
    //   38: ifeq +53 -> 91
    //   41: aload_3
    //   42: invokeinterface 64 1 0
    //   47: checkcast 66	java/lang/Long
    //   50: invokevirtual 70	java/lang/Long:longValue	()J
    //   53: lstore 4
    //   55: aload_0
    //   56: getfield 34	oicq/wlogin_sdk/request/WloginAllSigInfo:_tk_map	Ljava/util/TreeMap;
    //   59: lload 4
    //   61: invokestatic 74	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   64: invokevirtual 78	java/util/TreeMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   67: checkcast 80	oicq/wlogin_sdk/sharemem/WloginSigInfo
    //   70: astore_1
    //   71: aload_1
    //   72: ifnull -42 -> 30
    //   75: aload_1
    //   76: aconst_null
    //   77: putfield 84	oicq/wlogin_sdk/sharemem/WloginSigInfo:cacheTickets	Ljava/util/List;
    //   80: aload_1
    //   81: lconst_0
    //   82: putfield 87	oicq/wlogin_sdk/sharemem/WloginSigInfo:cacheUpdateStamp	J
    //   85: goto -55 -> 30
    //   88: astore_1
    //   89: aconst_null
    //   90: astore_1
    //   91: aload_1
    //   92: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	93	0	this	WloginAllSigInfo
    //   9	72	1	localObject	Object
    //   88	1	1	localException	Exception
    //   90	2	1	localWloginAllSigInfo1	WloginAllSigInfo
    //   7	24	2	localWloginAllSigInfo2	WloginAllSigInfo
    //   29	13	3	localIterator	java.util.Iterator
    //   53	7	4	l	long
    // Exception table:
    //   from	to	target	type
    //   0	8	88	java/lang/Exception
    //   10	30	88	java/lang/Exception
    //   32	71	88	java/lang/Exception
    //   75	85	88	java/lang/Exception
  }
  
  public int put_da2(long paramLong, byte[] paramArrayOfByte)
  {
    WloginSigInfo localWloginSigInfo = (WloginSigInfo)this._tk_map.get(Long.valueOf(paramLong));
    if (localWloginSigInfo != null) {
      this._tk_map.put(Long.valueOf(paramLong), localWloginSigInfo.setDA2(paramArrayOfByte));
    }
    return 0;
  }
  
  public int put_randseed(long paramLong, byte[] paramArrayOfByte)
  {
    WloginSigInfo localWloginSigInfo = (WloginSigInfo)this._tk_map.get(Long.valueOf(paramLong));
    if (localWloginSigInfo != null) {
      this._tk_map.put(Long.valueOf(paramLong), localWloginSigInfo.setRandSeed(paramArrayOfByte));
    }
    return 0;
  }
  
  public int put_siginfo(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, byte[] paramArrayOfByte5, byte[] paramArrayOfByte6, byte[] paramArrayOfByte7, byte[] paramArrayOfByte8, byte[] paramArrayOfByte9, byte[] paramArrayOfByte10, byte[] paramArrayOfByte11, byte[] paramArrayOfByte12, byte[][] paramArrayOfByte, long[] paramArrayOfLong, int paramInt)
  {
    WloginSigInfo localWloginSigInfo = (WloginSigInfo)this._tk_map.get(Long.valueOf(paramLong1));
    if (localWloginSigInfo != null)
    {
      localWloginSigInfo.mainSigMap = this.mainSigMap;
      this._tk_map.put(Long.valueOf(paramLong1), localWloginSigInfo.Set(paramLong2, paramLong3, paramLong4, paramLong5, paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte3, paramArrayOfByte4, paramArrayOfByte5, paramArrayOfByte6, paramArrayOfByte7, paramArrayOfByte8, paramArrayOfByte9, paramArrayOfByte10, paramArrayOfByte11, paramArrayOfByte12, paramArrayOfByte, paramArrayOfLong, paramInt));
    }
    for (;;)
    {
      return 0;
      this._tk_map.put(Long.valueOf(paramLong1), new WloginSigInfo(paramLong2, paramLong3, paramLong4, paramLong5, paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte3, paramArrayOfByte4, paramArrayOfByte5, paramArrayOfByte6, paramArrayOfByte7, paramArrayOfByte8, paramArrayOfByte9, paramArrayOfByte10, paramArrayOfByte11, paramArrayOfByte12, paramArrayOfByte, paramArrayOfLong, paramInt, this.mainSigMap));
    }
  }
  
  public int put_siginfo(long paramLong1, long paramLong2, long paramLong3, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    this._tk_map.put(Long.valueOf(paramLong1), new WloginSigInfo(paramLong2, paramLong3, paramArrayOfByte1, paramArrayOfByte2));
    return 0;
  }
  
  public int put_siginfo(long paramLong1, byte[][] paramArrayOfByte, long paramLong2)
  {
    WloginSigInfo localWloginSigInfo = (WloginSigInfo)this._tk_map.get(Long.valueOf(paramLong1));
    if (localWloginSigInfo != null) {
      this._tk_map.put(Long.valueOf(paramLong1), localWloginSigInfo.Set(paramArrayOfByte, paramLong2));
    }
    return 0;
  }
  
  public int put_simpleinfo(long paramLong, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, byte[][] paramArrayOfByte)
  {
    if (this._useInfo == null) {
      this._useInfo = new WloginSimpleInfo(paramLong, paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte3, paramArrayOfByte4, paramArrayOfByte);
    }
    for (;;)
    {
      return 0;
      this._useInfo.set_info(paramLong, paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte3, paramArrayOfByte4, paramArrayOfByte);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\oicq\wlogin_sdk\request\WloginAllSigInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */