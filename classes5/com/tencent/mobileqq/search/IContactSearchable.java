package com.tencent.mobileqq.search;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.search.util.SearchConfigManager;
import com.tencent.qphone.base.util.QLog;

public abstract class IContactSearchable
  implements ISearchable
{
  public static long A = SearchConfigManager.typeTroopConversation << SearchConfigManager.contactSearchTypeBaseBit;
  public static long B = SearchConfigManager.typeFriendSpecialCare << SearchConfigManager.contactSearchTypeBaseBit;
  public static long C = SearchConfigManager.typeFriend << SearchConfigManager.contactSearchTypeBaseBit;
  public static long D = SearchConfigManager.typeFriendNotOftenContact << SearchConfigManager.contactSearchTypeBaseBit;
  public static long E = SearchConfigManager.typeDiscussionMember << SearchConfigManager.contactSearchTypeBaseBit;
  public static long F = SearchConfigManager.typePhoneContact << SearchConfigManager.contactSearchTypeBaseBit;
  public static long G = SearchConfigManager.typeDiscussionConversationMatchMember << SearchConfigManager.contactSearchTypeBaseBit;
  public static long H = SearchConfigManager.typeDiscussion << SearchConfigManager.contactSearchTypeBaseBit;
  public static long I = SearchConfigManager.typeTroop << SearchConfigManager.contactSearchTypeBaseBit;
  public static long J = SearchConfigManager.typeTool << SearchConfigManager.contactSearchTypeBaseBit;
  public static long K = SearchConfigManager.typePublicAccountConversation << SearchConfigManager.contactSearchTypeBaseBit;
  public static long L = SearchConfigManager.typePublicAccount << SearchConfigManager.contactSearchTypeBaseBit;
  public static long M = SearchConfigManager.typeUnbindPhoneContact << SearchConfigManager.contactSearchTypeBaseBit;
  public static long N = SearchConfigManager.typeCircleContact << SearchConfigManager.contactSearchTypeBaseBit;
  public static long O = SearchConfigManager.typeTroopMember << SearchConfigManager.contactSearchTypeBaseBit;
  public static long P = SearchConfigManager.typeGlobalTroop << SearchConfigManager.contactSearchTypeBaseBit;
  public static long Q = SearchConfigManager.typeGlobalTroopConversation << SearchConfigManager.contactSearchTypeBaseBit;
  public static long R = SearchConfigManager.typeGlobalTroopMember << SearchConfigManager.contactSearchTypeBaseBit;
  public static final long S = 0L;
  public static final long T = 0L;
  public static final long U = 0L;
  public static final long V = 0L;
  public static final long W = 0L;
  public static long a;
  public static long b;
  public static long c;
  public static long d;
  public static long e;
  public static long f;
  public static long g;
  public static long h;
  public static long i;
  public static long j;
  public static long k;
  public static long l;
  public static long m;
  public static long n;
  public static long o;
  public static long p;
  public static long q;
  public static long r;
  public static long s;
  public static long t;
  public static long u;
  public static long v;
  public static long w;
  public static long x;
  public static long y;
  public static long z;
  protected long X;
  protected long Y = -1L;
  protected long Z;
  protected long aa;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    a = SearchConfigManager.fieldPublicAccountName << SearchConfigManager.contactSearchFieldBaseBit;
    b = SearchConfigManager.fieldPublicAccountMark << SearchConfigManager.contactSearchFieldBaseBit;
    c = SearchConfigManager.fieldPublicAccountSummary << SearchConfigManager.contactSearchFieldBaseBit;
    d = SearchConfigManager.fieldPublicAccountDisplayName << SearchConfigManager.contactSearchFieldBaseBit;
    e = SearchConfigManager.filedDiscussionName << SearchConfigManager.contactSearchFieldBaseBit;
    f = SearchConfigManager.fieldTroopName << SearchConfigManager.contactSearchFieldBaseBit;
    g = SearchConfigManager.fieldRemark << SearchConfigManager.contactSearchFieldBaseBit;
    h = SearchConfigManager.fieldDiscussionMemberRemark << SearchConfigManager.contactSearchFieldBaseBit;
    i = SearchConfigManager.fieldInteRemark << SearchConfigManager.contactSearchFieldBaseBit;
    j = SearchConfigManager.fieldNickName << SearchConfigManager.contactSearchFieldBaseBit;
    k = SearchConfigManager.fieldPhoneContactName << SearchConfigManager.contactSearchFieldBaseBit;
    l = SearchConfigManager.fieldAlias << SearchConfigManager.contactSearchFieldBaseBit;
    m = SearchConfigManager.fieldUin << SearchConfigManager.contactSearchFieldBaseBit;
    n = SearchConfigManager.fieldMobileNo << SearchConfigManager.contactSearchFieldBaseBit;
    o = SearchConfigManager.fieldTroopCard << SearchConfigManager.contactSearchFieldBaseBit;
    p = SearchConfigManager.stringOrigin << SearchConfigManager.contactSearchPinyinBaseBit;
    q = SearchConfigManager.stringPinyin << SearchConfigManager.contactSearchPinyinBaseBit;
    r = SearchConfigManager.recentTrue << SearchConfigManager.contactSearchRecentBaseBit;
    s = SearchConfigManager.indexEqual << SearchConfigManager.contactSearchIndexBaseBit;
    t = SearchConfigManager.indexStart << SearchConfigManager.contactSearchIndexBaseBit;
    u = SearchConfigManager.indexMiddle << SearchConfigManager.contactSearchIndexBaseBit;
    v = 72057594037927936L;
    w = SearchConfigManager.typeDiscussionMatchMemberFull << SearchConfigManager.contactSearchTypeBaseBit;
    x = SearchConfigManager.typeFriendConversation << SearchConfigManager.contactSearchTypeBaseBit;
    y = SearchConfigManager.typeDiscussionConversationMatchTitle << SearchConfigManager.contactSearchTypeBaseBit;
    z = SearchConfigManager.typeDiscussionConversation << SearchConfigManager.contactSearchTypeBaseBit;
  }
  
  public static void a()
  {
    a = SearchConfigManager.fieldPublicAccountName << SearchConfigManager.contactSearchFieldBaseBit;
    b = SearchConfigManager.fieldPublicAccountMark << SearchConfigManager.contactSearchFieldBaseBit;
    c = SearchConfigManager.fieldPublicAccountSummary << SearchConfigManager.contactSearchFieldBaseBit;
    d = SearchConfigManager.fieldPublicAccountDisplayName << SearchConfigManager.contactSearchFieldBaseBit;
    e = SearchConfigManager.filedDiscussionName << SearchConfigManager.contactSearchFieldBaseBit;
    f = SearchConfigManager.fieldTroopName << SearchConfigManager.contactSearchFieldBaseBit;
    g = SearchConfigManager.fieldRemark << SearchConfigManager.contactSearchFieldBaseBit;
    h = SearchConfigManager.fieldDiscussionMemberRemark << SearchConfigManager.contactSearchFieldBaseBit;
    i = SearchConfigManager.fieldInteRemark << SearchConfigManager.contactSearchFieldBaseBit;
    j = SearchConfigManager.fieldNickName << SearchConfigManager.contactSearchFieldBaseBit;
    k = SearchConfigManager.fieldPhoneContactName << SearchConfigManager.contactSearchFieldBaseBit;
    l = SearchConfigManager.fieldAlias << SearchConfigManager.contactSearchFieldBaseBit;
    m = SearchConfigManager.fieldUin << SearchConfigManager.contactSearchFieldBaseBit;
    n = SearchConfigManager.fieldMobileNo << SearchConfigManager.contactSearchFieldBaseBit;
    o = SearchConfigManager.fieldTroopCard << SearchConfigManager.contactSearchFieldBaseBit;
    p = SearchConfigManager.stringOrigin << SearchConfigManager.contactSearchPinyinBaseBit;
    q = SearchConfigManager.stringPinyin << SearchConfigManager.contactSearchPinyinBaseBit;
    r = SearchConfigManager.recentTrue << SearchConfigManager.contactSearchRecentBaseBit;
    s = SearchConfigManager.indexEqual << SearchConfigManager.contactSearchIndexBaseBit;
    t = SearchConfigManager.indexStart << SearchConfigManager.contactSearchIndexBaseBit;
    u = SearchConfigManager.indexMiddle << SearchConfigManager.contactSearchIndexBaseBit;
    v = 72057594037927936L;
    w = SearchConfigManager.typeDiscussionMatchMemberFull << SearchConfigManager.contactSearchTypeBaseBit;
    x = SearchConfigManager.typeFriendConversation << SearchConfigManager.contactSearchTypeBaseBit;
    y = SearchConfigManager.typeDiscussionConversationMatchTitle << SearchConfigManager.contactSearchTypeBaseBit;
    z = SearchConfigManager.typeDiscussionConversation << SearchConfigManager.contactSearchTypeBaseBit;
    A = SearchConfigManager.typeTroopConversation << SearchConfigManager.contactSearchTypeBaseBit;
    B = SearchConfigManager.typeFriendSpecialCare << SearchConfigManager.contactSearchTypeBaseBit;
    C = SearchConfigManager.typeFriend << SearchConfigManager.contactSearchTypeBaseBit;
    D = SearchConfigManager.typeFriendNotOftenContact << SearchConfigManager.contactSearchTypeBaseBit;
    E = SearchConfigManager.typeDiscussionMember << SearchConfigManager.contactSearchTypeBaseBit;
    F = SearchConfigManager.typePhoneContact << SearchConfigManager.contactSearchTypeBaseBit;
    G = SearchConfigManager.typeDiscussionConversationMatchMember << SearchConfigManager.contactSearchTypeBaseBit;
    H = SearchConfigManager.typeDiscussion << SearchConfigManager.contactSearchTypeBaseBit;
    I = SearchConfigManager.typeTroop << SearchConfigManager.contactSearchTypeBaseBit;
    J = SearchConfigManager.typeTool << SearchConfigManager.contactSearchTypeBaseBit;
    K = SearchConfigManager.typePublicAccountConversation << SearchConfigManager.contactSearchTypeBaseBit;
    L = SearchConfigManager.typePublicAccount << SearchConfigManager.contactSearchTypeBaseBit;
    M = SearchConfigManager.typeUnbindPhoneContact << SearchConfigManager.contactSearchTypeBaseBit;
    N = SearchConfigManager.typeCircleContact << SearchConfigManager.contactSearchTypeBaseBit;
    O = SearchConfigManager.typeTroopMember << SearchConfigManager.contactSearchTypeBaseBit;
    P = SearchConfigManager.typeGlobalTroop << SearchConfigManager.contactSearchTypeBaseBit;
    Q = SearchConfigManager.typeGlobalTroopConversation << SearchConfigManager.contactSearchTypeBaseBit;
    R = SearchConfigManager.typeGlobalTroopMember << SearchConfigManager.contactSearchTypeBaseBit;
  }
  
  protected long a()
  {
    return 0L;
  }
  
  public abstract Drawable a();
  
  public abstract Object a();
  
  public abstract String a();
  
  public void a(long paramLong)
  {
    this.Z = paramLong;
  }
  
  public abstract int b();
  
  public long b()
  {
    return d() - this.aa;
  }
  
  public abstract String b();
  
  protected void b()
  {
    for (;;)
    {
      int i1;
      try
      {
        String str = d();
        StringBuilder localStringBuilder = new StringBuilder();
        i1 = 0;
        if (i1 < str.length())
        {
          char c1 = str.charAt(i1);
          if ((c1 >= '0') && (c1 <= '9')) {
            localStringBuilder.append(c1);
          }
        }
        else
        {
          str = localStringBuilder.toString();
          if (!TextUtils.isEmpty(str))
          {
            this.X = Long.parseLong(str);
            return;
          }
          this.X = hashCode();
          return;
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          localException.printStackTrace();
        }
        this.X = hashCode();
        return;
      }
      i1 += 1;
    }
  }
  
  public abstract int c();
  
  public long c()
  {
    return e();
  }
  
  public abstract String c();
  
  public long d()
  {
    return this.Z;
  }
  
  public abstract String d();
  
  public long e()
  {
    if (this.Y == -1L) {
      this.Y = a();
    }
    return this.Y;
  }
  
  public boolean equals(Object paramObject)
  {
    return this.X == ((IContactSearchable)paramObject).X;
  }
  
  public int hashCode()
  {
    return super.hashCode();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\search\IContactSearchable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */