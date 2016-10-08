package com.fasterxml.jackson.core.sym;

import com.fasterxml.jackson.core.util.InternCache;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

public final class BytesToNameCanonicalizer
{
  protected static final int DEFAULT_TABLE_SIZE = 64;
  static final int INITIAL_COLLISION_LEN = 32;
  static final int LAST_VALID_BUCKET = 254;
  static final int MAX_COLL_CHAIN_FOR_REUSE = 63;
  static final int MAX_COLL_CHAIN_LENGTH = 255;
  static final int MAX_ENTRIES_FOR_REUSE = 6000;
  protected static final int MAX_TABLE_SIZE = 65536;
  static final int MIN_HASH_SIZE = 16;
  private static final int MULT = 33;
  private static final int MULT2 = 65599;
  private static final int MULT3 = 31;
  protected int _collCount;
  protected int _collEnd;
  protected Bucket[] _collList;
  private boolean _collListShared;
  protected int _count;
  private final int _hashSeed;
  protected final boolean _intern;
  protected int _longestCollisionList;
  protected int[] _mainHash;
  protected int _mainHashMask;
  private boolean _mainHashShared;
  protected Name[] _mainNames;
  private boolean _mainNamesShared;
  private transient boolean _needRehash;
  protected final BytesToNameCanonicalizer _parent;
  protected final AtomicReference<TableInfo> _tableInfo;
  
  private BytesToNameCanonicalizer(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    this._parent = null;
    this._hashSeed = paramInt2;
    this._intern = paramBoolean;
    if (paramInt1 < 16) {
      paramInt2 = 16;
    }
    for (;;)
    {
      this._tableInfo = new AtomicReference(initTableInfo(paramInt2));
      return;
      paramInt2 = paramInt1;
      if ((paramInt1 - 1 & paramInt1) != 0)
      {
        paramInt2 = 16;
        while (paramInt2 < paramInt1) {
          paramInt2 += paramInt2;
        }
      }
    }
  }
  
  private BytesToNameCanonicalizer(BytesToNameCanonicalizer paramBytesToNameCanonicalizer, boolean paramBoolean, int paramInt, TableInfo paramTableInfo)
  {
    this._parent = paramBytesToNameCanonicalizer;
    this._hashSeed = paramInt;
    this._intern = paramBoolean;
    this._tableInfo = null;
    this._count = paramTableInfo.count;
    this._mainHashMask = paramTableInfo.mainHashMask;
    this._mainHash = paramTableInfo.mainHash;
    this._mainNames = paramTableInfo.mainNames;
    this._collList = paramTableInfo.collList;
    this._collCount = paramTableInfo.collCount;
    this._collEnd = paramTableInfo.collEnd;
    this._longestCollisionList = paramTableInfo.longestCollisionList;
    this._needRehash = false;
    this._mainHashShared = true;
    this._mainNamesShared = true;
    this._collListShared = true;
  }
  
  private void _addSymbol(int paramInt, Name paramName)
  {
    if (this._mainHashShared) {
      unshareMain();
    }
    if (this._needRehash) {
      rehash();
    }
    this._count += 1;
    int j = paramInt & this._mainHashMask;
    int i;
    if (this._mainNames[j] == null)
    {
      this._mainHash[j] = (paramInt << 8);
      if (this._mainNamesShared) {
        unshareNames();
      }
      this._mainNames[j] = paramName;
      paramInt = this._mainHash.length;
      if (this._count > paramInt >> 1)
      {
        i = paramInt >> 2;
        if (this._count <= paramInt - i) {
          break label288;
        }
        this._needRehash = true;
      }
    }
    label199:
    label288:
    while (this._collCount < i)
    {
      return;
      if (this._collListShared) {
        unshareCollision();
      }
      this._collCount += 1;
      int k = this._mainHash[j];
      paramInt = k & 0xFF;
      if (paramInt == 0) {
        if (this._collEnd <= 254)
        {
          i = this._collEnd;
          this._collEnd += 1;
          paramInt = i;
          if (i >= this._collList.length)
          {
            expandCollision();
            paramInt = i;
          }
          this._mainHash[j] = (k & 0xFF00 | paramInt + 1);
        }
      }
      for (;;)
      {
        paramName = new Bucket(paramName, this._collList[paramInt]);
        this._collList[paramInt] = paramName;
        this._longestCollisionList = Math.max(paramName.length(), this._longestCollisionList);
        if (this._longestCollisionList <= 255) {
          break;
        }
        reportTooManyCollisions(255);
        break;
        paramInt = findBestBucket();
        break label199;
        paramInt -= 1;
      }
    }
    this._needRehash = true;
  }
  
  protected static int[] calcQuads(byte[] paramArrayOfByte)
  {
    int n = paramArrayOfByte.length;
    int[] arrayOfInt = new int[(n + 3) / 4];
    int j;
    for (int i = 0;; i = j + 1)
    {
      if (i >= n) {
        return arrayOfInt;
      }
      int k = paramArrayOfByte[i] & 0xFF;
      int m = i + 1;
      j = m;
      i = k;
      if (m < n)
      {
        k = k << 8 | paramArrayOfByte[m] & 0xFF;
        m += 1;
        j = m;
        i = k;
        if (m < n)
        {
          k = k << 8 | paramArrayOfByte[m] & 0xFF;
          m += 1;
          j = m;
          i = k;
          if (m < n)
          {
            i = k << 8 | paramArrayOfByte[m] & 0xFF;
            j = m;
          }
        }
      }
      arrayOfInt[(j >> 2)] = i;
    }
  }
  
  private static Name constructName(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    if (paramInt3 == 0) {
      return new Name1(paramString, paramInt1, paramInt2);
    }
    return new Name2(paramString, paramInt1, paramInt2, paramInt3);
  }
  
  private static Name constructName(int paramInt1, String paramString, int[] paramArrayOfInt, int paramInt2)
  {
    if (paramInt2 < 4) {}
    int[] arrayOfInt;
    int i;
    switch (paramInt2)
    {
    default: 
      arrayOfInt = new int[paramInt2];
      i = 0;
    }
    for (;;)
    {
      if (i >= paramInt2)
      {
        return new NameN(paramString, paramInt1, arrayOfInt, paramInt2);
        return new Name1(paramString, paramInt1, paramArrayOfInt[0]);
        return new Name2(paramString, paramInt1, paramArrayOfInt[0], paramArrayOfInt[1]);
        return new Name3(paramString, paramInt1, paramArrayOfInt[0], paramArrayOfInt[1], paramArrayOfInt[2]);
      }
      arrayOfInt[i] = paramArrayOfInt[i];
      i += 1;
    }
  }
  
  public static BytesToNameCanonicalizer createRoot()
  {
    long l = System.currentTimeMillis();
    return createRoot((int)l + (int)(l >>> 32) | 0x1);
  }
  
  protected static BytesToNameCanonicalizer createRoot(int paramInt)
  {
    return new BytesToNameCanonicalizer(64, true, paramInt);
  }
  
  private void expandCollision()
  {
    Bucket[] arrayOfBucket = this._collList;
    int i = arrayOfBucket.length;
    this._collList = new Bucket[i + i];
    System.arraycopy(arrayOfBucket, 0, this._collList, 0, i);
  }
  
  private int findBestBucket()
  {
    Bucket[] arrayOfBucket = this._collList;
    int k = Integer.MAX_VALUE;
    int j = -1;
    int i = 0;
    int i1 = this._collEnd;
    for (;;)
    {
      if (i >= i1) {}
      int n;
      do
      {
        return j;
        n = arrayOfBucket[i].length();
        m = k;
        if (n >= k) {
          break;
        }
        j = i;
      } while (n == 1);
      int m = n;
      j = i;
      i += 1;
      k = m;
    }
  }
  
  public static Name getEmptyName()
  {
    return Name1.getEmptyName();
  }
  
  private TableInfo initTableInfo(int paramInt)
  {
    return new TableInfo(0, paramInt - 1, new int[paramInt], new Name[paramInt], null, 0, 0, 0);
  }
  
  private void mergeChild(TableInfo paramTableInfo)
  {
    int i = paramTableInfo.count;
    TableInfo localTableInfo2 = (TableInfo)this._tableInfo.get();
    if (i <= localTableInfo2.count) {
      return;
    }
    TableInfo localTableInfo1;
    if (i <= 6000)
    {
      localTableInfo1 = paramTableInfo;
      if (paramTableInfo.longestCollisionList <= 63) {}
    }
    else
    {
      localTableInfo1 = initTableInfo(64);
    }
    this._tableInfo.compareAndSet(localTableInfo2, localTableInfo1);
  }
  
  private void nukeSymbols()
  {
    this._count = 0;
    this._longestCollisionList = 0;
    Arrays.fill(this._mainHash, 0);
    Arrays.fill(this._mainNames, null);
    Arrays.fill(this._collList, null);
    this._collCount = 0;
    this._collEnd = 0;
  }
  
  private void rehash()
  {
    this._needRehash = false;
    this._mainNamesShared = false;
    int m = this._mainHash.length;
    int i = m + m;
    if (i > 65536) {
      nukeSymbols();
    }
    int j;
    Bucket[] arrayOfBucket;
    int k;
    int n;
    do
    {
      return;
      this._mainHash = new int[i];
      this._mainHashMask = (i - 1);
      localObject1 = this._mainNames;
      this._mainNames = new Name[i];
      i = 0;
      j = 0;
      int i1;
      for (;;)
      {
        if (j >= m)
        {
          i1 = this._collEnd;
          if (i1 != 0) {
            break;
          }
          this._longestCollisionList = 0;
          return;
        }
        arrayOfBucket = localObject1[j];
        k = i;
        if (arrayOfBucket != null)
        {
          k = i + 1;
          i = arrayOfBucket.hashCode();
          n = i & this._mainHashMask;
          this._mainNames[n] = arrayOfBucket;
          this._mainHash[n] = (i << 8);
        }
        j += 1;
        i = k;
      }
      this._collCount = 0;
      this._collEnd = 0;
      this._collListShared = false;
      k = 0;
      arrayOfBucket = this._collList;
      this._collList = new Bucket[arrayOfBucket.length];
      j = 0;
      if (j < i1) {
        break;
      }
      this._longestCollisionList = k;
    } while (i == this._count);
    throw new RuntimeException("Internal error: count after rehash " + i + "; should be " + this._count);
    Object localObject1 = arrayOfBucket[j];
    Object localObject2;
    int i2;
    int i3;
    for (;;)
    {
      if (localObject1 == null)
      {
        j += 1;
        break;
      }
      m = i + 1;
      localObject2 = ((Bucket)localObject1)._name;
      i = ((Name)localObject2).hashCode();
      i2 = i & this._mainHashMask;
      i3 = this._mainHash[i2];
      if (this._mainNames[i2] != null) {
        break label353;
      }
      this._mainHash[i2] = (i << 8);
      this._mainNames[i2] = localObject2;
      localObject1 = ((Bucket)localObject1)._next;
      i = m;
    }
    label353:
    this._collCount += 1;
    i = i3 & 0xFF;
    if (i == 0) {
      if (this._collEnd <= 254)
      {
        n = this._collEnd;
        this._collEnd += 1;
        i = n;
        if (n >= this._collList.length)
        {
          expandCollision();
          i = n;
        }
        label424:
        this._mainHash[i2] = (i3 & 0xFF00 | i + 1);
      }
    }
    for (;;)
    {
      localObject2 = new Bucket((Name)localObject2, this._collList[i]);
      this._collList[i] = localObject2;
      k = Math.max(k, ((Bucket)localObject2).length());
      break;
      i = findBestBucket();
      break label424;
      i -= 1;
    }
  }
  
  private void unshareCollision()
  {
    Bucket[] arrayOfBucket = this._collList;
    if (arrayOfBucket == null) {
      this._collList = new Bucket[32];
    }
    for (;;)
    {
      this._collListShared = false;
      return;
      int i = arrayOfBucket.length;
      this._collList = new Bucket[i];
      System.arraycopy(arrayOfBucket, 0, this._collList, 0, i);
    }
  }
  
  private void unshareMain()
  {
    int[] arrayOfInt = this._mainHash;
    int i = this._mainHash.length;
    this._mainHash = new int[i];
    System.arraycopy(arrayOfInt, 0, this._mainHash, 0, i);
    this._mainHashShared = false;
  }
  
  private void unshareNames()
  {
    Name[] arrayOfName = this._mainNames;
    int i = arrayOfName.length;
    this._mainNames = new Name[i];
    System.arraycopy(arrayOfName, 0, this._mainNames, 0, i);
    this._mainNamesShared = false;
  }
  
  public Name addName(String paramString, int paramInt1, int paramInt2)
  {
    String str = paramString;
    if (this._intern) {
      str = InternCache.instance.intern(paramString);
    }
    if (paramInt2 == 0) {}
    for (int i = calcHash(paramInt1);; i = calcHash(paramInt1, paramInt2))
    {
      paramString = constructName(i, str, paramInt1, paramInt2);
      _addSymbol(i, paramString);
      return paramString;
    }
  }
  
  public Name addName(String paramString, int[] paramArrayOfInt, int paramInt)
  {
    String str = paramString;
    if (this._intern) {
      str = InternCache.instance.intern(paramString);
    }
    int i;
    if (paramInt < 3) {
      if (paramInt == 1) {
        i = calcHash(paramArrayOfInt[0]);
      }
    }
    for (;;)
    {
      paramString = constructName(i, str, paramArrayOfInt, paramInt);
      _addSymbol(i, paramString);
      return paramString;
      i = calcHash(paramArrayOfInt[0], paramArrayOfInt[1]);
      continue;
      i = calcHash(paramArrayOfInt, paramInt);
    }
  }
  
  public int bucketCount()
  {
    return this._mainHash.length;
  }
  
  public int calcHash(int paramInt)
  {
    paramInt ^= this._hashSeed;
    paramInt += (paramInt >>> 15);
    return paramInt ^ paramInt >>> 9;
  }
  
  public int calcHash(int paramInt1, int paramInt2)
  {
    paramInt1 = (paramInt1 ^ paramInt1 >>> 15) + paramInt2 * 33 ^ this._hashSeed;
    return paramInt1 + (paramInt1 >>> 7);
  }
  
  public int calcHash(int[] paramArrayOfInt, int paramInt)
  {
    if (paramInt < 3) {
      throw new IllegalArgumentException();
    }
    int i = paramArrayOfInt[0] ^ this._hashSeed;
    i = ((i + (i >>> 9)) * 33 + paramArrayOfInt[1]) * 65599;
    i = i + (i >>> 15) ^ paramArrayOfInt[2];
    int j = i + (i >>> 17);
    i = 3;
    for (;;)
    {
      if (i >= paramInt)
      {
        paramInt = j + (j >>> 15);
        return paramInt ^ paramInt << 9;
      }
      j = j * 31 ^ paramArrayOfInt[i];
      j += (j >>> 3);
      j ^= j << 7;
      i += 1;
    }
  }
  
  public int collisionCount()
  {
    return this._collCount;
  }
  
  public Name findName(int paramInt)
  {
    int i = calcHash(paramInt);
    int j = i & this._mainHashMask;
    int k = this._mainHash[j];
    if ((k >> 8 ^ i) << 8 == 0)
    {
      localName = this._mainNames[j];
      if (localName == null) {
        localObject = null;
      }
      do
      {
        return (Name)localObject;
        localObject = localName;
      } while (localName.equals(paramInt));
    }
    while (k != 0)
    {
      Name localName;
      j = k & 0xFF;
      if (j <= 0) {
        break;
      }
      Object localObject = this._collList[(j - 1)];
      if (localObject == null) {
        break;
      }
      return ((Bucket)localObject).find(i, paramInt, 0);
    }
    return null;
    return null;
  }
  
  public Name findName(int paramInt1, int paramInt2)
  {
    int i;
    int j;
    int k;
    if (paramInt2 == 0)
    {
      i = calcHash(paramInt1);
      j = i & this._mainHashMask;
      k = this._mainHash[j];
      if ((k >> 8 ^ i) << 8 != 0) {
        break label121;
      }
      localName = this._mainNames[j];
      if (localName != null) {
        break label72;
      }
      localObject = null;
    }
    label72:
    do
    {
      return (Name)localObject;
      i = calcHash(paramInt1, paramInt2);
      break;
      localObject = localName;
    } while (localName.equals(paramInt1, paramInt2));
    label121:
    while (k != 0)
    {
      Name localName;
      j = k & 0xFF;
      if (j <= 0) {
        break;
      }
      Object localObject = this._collList[(j - 1)];
      if (localObject == null) {
        break;
      }
      return ((Bucket)localObject).find(i, paramInt1, paramInt2);
    }
    return null;
    return null;
  }
  
  public Name findName(int[] paramArrayOfInt, int paramInt)
  {
    int i = 0;
    int j;
    Object localObject;
    if (paramInt < 3)
    {
      j = paramArrayOfInt[0];
      if (paramInt < 2)
      {
        paramInt = i;
        localObject = findName(j, paramInt);
      }
    }
    int k;
    do
    {
      do
      {
        return (Name)localObject;
        paramInt = paramArrayOfInt[1];
        break;
        i = calcHash(paramArrayOfInt, paramInt);
        j = i & this._mainHashMask;
        k = this._mainHash[j];
        if ((k >> 8 ^ i) << 8 != 0) {
          break label144;
        }
        localName = this._mainNames[j];
        localObject = localName;
      } while (localName == null);
      localObject = localName;
    } while (localName.equals(paramArrayOfInt, paramInt));
    label144:
    while (k != 0)
    {
      Name localName;
      j = k & 0xFF;
      if (j <= 0) {
        break;
      }
      localObject = this._collList[(j - 1)];
      if (localObject == null) {
        break;
      }
      return ((Bucket)localObject).find(i, paramArrayOfInt, paramInt);
    }
    return null;
    return null;
  }
  
  public int hashSeed()
  {
    return this._hashSeed;
  }
  
  public BytesToNameCanonicalizer makeChild(boolean paramBoolean1, boolean paramBoolean2)
  {
    return new BytesToNameCanonicalizer(this, paramBoolean2, this._hashSeed, (TableInfo)this._tableInfo.get());
  }
  
  public int maxCollisionLength()
  {
    return this._longestCollisionList;
  }
  
  public boolean maybeDirty()
  {
    return !this._mainHashShared;
  }
  
  public void release()
  {
    if ((this._parent != null) && (maybeDirty()))
    {
      this._parent.mergeChild(new TableInfo(this));
      this._mainHashShared = true;
      this._mainNamesShared = true;
      this._collListShared = true;
    }
  }
  
  protected void reportTooManyCollisions(int paramInt)
  {
    throw new IllegalStateException("Longest collision chain in symbol table (of size " + this._count + ") now exceeds maximum, " + paramInt + " -- suspect a DoS attack based on hash collisions");
  }
  
  public int size()
  {
    if (this._tableInfo != null) {
      return ((TableInfo)this._tableInfo.get()).count;
    }
    return this._count;
  }
  
  static final class Bucket
  {
    private final int _length;
    protected final Name _name;
    protected final Bucket _next;
    
    Bucket(Name paramName, Bucket paramBucket)
    {
      this._name = paramName;
      this._next = paramBucket;
      if (paramBucket == null) {}
      for (int i = 1;; i = paramBucket._length + 1)
      {
        this._length = i;
        return;
      }
    }
    
    public Name find(int paramInt1, int paramInt2, int paramInt3)
    {
      Object localObject;
      if ((this._name.hashCode() == paramInt1) && (this._name.equals(paramInt2, paramInt3)))
      {
        localObject = this._name;
        return (Name)localObject;
      }
      for (Bucket localBucket = this._next;; localBucket = localBucket._next)
      {
        if (localBucket == null) {
          return null;
        }
        Name localName = localBucket._name;
        if (localName.hashCode() == paramInt1)
        {
          localObject = localName;
          if (localName.equals(paramInt2, paramInt3)) {
            break;
          }
        }
      }
    }
    
    public Name find(int paramInt1, int[] paramArrayOfInt, int paramInt2)
    {
      Object localObject;
      if ((this._name.hashCode() == paramInt1) && (this._name.equals(paramArrayOfInt, paramInt2)))
      {
        localObject = this._name;
        return (Name)localObject;
      }
      for (Bucket localBucket = this._next;; localBucket = localBucket._next)
      {
        if (localBucket == null) {
          return null;
        }
        Name localName = localBucket._name;
        if (localName.hashCode() == paramInt1)
        {
          localObject = localName;
          if (localName.equals(paramArrayOfInt, paramInt2)) {
            break;
          }
        }
      }
    }
    
    public int length()
    {
      return this._length;
    }
  }
  
  private static final class TableInfo
  {
    public final int collCount;
    public final int collEnd;
    public final BytesToNameCanonicalizer.Bucket[] collList;
    public final int count;
    public final int longestCollisionList;
    public final int[] mainHash;
    public final int mainHashMask;
    public final Name[] mainNames;
    
    public TableInfo(int paramInt1, int paramInt2, int[] paramArrayOfInt, Name[] paramArrayOfName, BytesToNameCanonicalizer.Bucket[] paramArrayOfBucket, int paramInt3, int paramInt4, int paramInt5)
    {
      this.count = paramInt1;
      this.mainHashMask = paramInt2;
      this.mainHash = paramArrayOfInt;
      this.mainNames = paramArrayOfName;
      this.collList = paramArrayOfBucket;
      this.collCount = paramInt3;
      this.collEnd = paramInt4;
      this.longestCollisionList = paramInt5;
    }
    
    public TableInfo(BytesToNameCanonicalizer paramBytesToNameCanonicalizer)
    {
      this.count = paramBytesToNameCanonicalizer._count;
      this.mainHashMask = paramBytesToNameCanonicalizer._mainHashMask;
      this.mainHash = paramBytesToNameCanonicalizer._mainHash;
      this.mainNames = paramBytesToNameCanonicalizer._mainNames;
      this.collList = paramBytesToNameCanonicalizer._collList;
      this.collCount = paramBytesToNameCanonicalizer._collCount;
      this.collEnd = paramBytesToNameCanonicalizer._collEnd;
      this.longestCollisionList = paramBytesToNameCanonicalizer._longestCollisionList;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\fasterxml\jackson\core\sym\BytesToNameCanonicalizer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */