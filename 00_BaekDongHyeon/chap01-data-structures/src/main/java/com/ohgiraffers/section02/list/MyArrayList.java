package com.ohgiraffers.section02.list;

/**
 * 배열 기반 동적 배열(ArrayList) 직접 구현한 클래스.
 * 제네릭을 이용해서 모든 타입의 데이터를 저장할 수 있다.
 */
public class MyArrayList<T> {
  
  // 내부 데이터 저장 공간
  private T[] data;
  
  // 현재 저장된 요소의 개수
  private int size; 
  
  // 사용자가 리스트의 용량을 지정하지 않을 경우 사용할 기본 값
  private static final int DEFAULT_CAPACITY = 10;

  /**
   * 기본 생성자 - 초기 용량 10으로 생성
   * 
   * @SuppressWarnings("unchecked") 
   * - 해당 부분에서 발생하는 제네릭 관련 안정성 경고를 무시하라고 
   *   컴파일러에게 알려주는 어노테이션
   */
  @SuppressWarnings("unchecked") 
  public MyArrayList(){
    // Object[] 생성 후 T[]로 강제 형변환
    // -> Java에서는 제네릭 배열을 직접 생성할 수 없기 때문이다.
    data = (T[]) new Object[DEFAULT_CAPACITY];
    size = 0; // 저장된 요소 개수 0개
  }

  /**
   * 사용자가 초기 용량을 지정하는 생성자
   * */
  public MyArrayList(int initialCapacity){

    if(initialCapacity < 0){
      throw new IllegalArgumentException("잘못된 용량 : " + initialCapacity);
    }

    data = (T[]) new Object[initialCapacity];
    size = 0; // 저장된 요소 개수 0개
  }

  /**
   * 리스트 끝에 요소를 추가.
   * 시간 복잡도
   * - 평균 : O(1)
   * - 배열 크기 재 조정 시 : O(n)
   * @param element
   */
  public void add(T element){

    // 1. data 배열이 가득 찼는지 확인
    if(data.length == size){
      // 2. 배열의 크기를 2배 증가 시키기
      resize();
    }

    // 끝에 요소를 추가 후 size 1증가
    data[size++] = element;
  }

  /**
   * - 배열의 용량을 재조정하기 위한 헬퍼 메서드
   * - 현재 배열의 크기를 2배로 늘리고 요소를 복사함.
   */
  private void resize(){

    // 1. 기존 용량의 2배 계산
    int newCapacity = data.length * 2;

    // 2. 새로운 용량의 새 배열 생성
    T[] newData = (T[]) new Object[newCapacity];

    // 3. 기존 배열의 모든 요소를 새 배열로 복사 ( O(n) )
    System.arraycopy(data, 0, newData, 0, data.length);

    // 4. data 참조 변수가 새 배열을 참조하도록 함.
    data = newData;



  }
  
}







