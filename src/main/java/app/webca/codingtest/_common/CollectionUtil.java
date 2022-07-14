package app.webca.codingtest._common;

import java.util.List;

/**
 * <pre>
 * Collection<I> : 순서나 집합적인 저장공간
 *  - List<I> : 순서가 있는 저장공간. 중복(O)
 *   - LinkedList : 검색 속도가 느리고 수정, 추가, 삭제가 빠르다.
 *   - Stack : LIFO
 *   - Vector : 동기화 보장
 *   - ArrayList : 동기화 보장하지 않음
 *  - Set<I> : 집합적인 저장공간. 중복(X). AND, OR, XOR 지원
 *   - HashSet : 정렬(X)
 *    - LinkedHashSet : HashSet 대비 수정/삽입 빠름. 검색 느림.
 *   - SortedSet<I> : 정렬(O)
 *    - TreeSet : 대량 데이터 검색 시 매우 빠름
 * </pre>
 */
public class CollectionUtil {

    public static boolean find(List<Integer> num, int k) {
        return num.contains(k);
    }
    
}
