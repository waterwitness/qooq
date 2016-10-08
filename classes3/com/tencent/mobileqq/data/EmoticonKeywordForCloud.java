package com.tencent.mobileqq.data;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.uniqueConstraints;

@uniqueConstraints(clause=ConflictClause.IGNORE, columnNames="eId,epId,keyword")
public class EmoticonKeywordForCloud
  extends EmoticonKeyword
{
  public static final int EM_TYPE_LOADING = 1;
  public static final int EM_TYPE_LOAD_FAILED = 3;
  public static final int EM_TYPE_LOAD_OK = 2;
  public static final int EM_TYPE_UNKNOW = 0;
  public String inputKeyword;
  public int loadedType;
  public int type;
  
  public EmoticonKeywordForCloud()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\data\EmoticonKeywordForCloud.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */