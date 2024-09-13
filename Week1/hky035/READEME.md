## 결과 
실패 

## 풀이
해당 자원 요구량과 자원 보유량, 운반 가능량, 소요 시간을 받아 자원 요구량을 다 소모할 때까지 계산하는 `calc()` 메서드 생성   
→    
남은 자원 요구량 계산 : `gold -= Math.min(w[i], g[i])`   
자원 운반 후 시간 계산 : `timeCountList[cityIdx] += ((timeCountList[cityIdx]==0) ? t[cityIdx] : 2 * t[cityIdx]);`
> 한 번 운반한 적이 있으면 다시 되돌아가는 시간을 고려하여 시간을 2배하여 더함

→    
gold와 silver에 대한 `calc()` 메서드 수행 후 각 도시에서 운송하는데 걸린 시간 `timeCountList[]`에서 maxValue를 계산



## 실패 원인 분석
gold, silver를 단순히 순차적으로 계산

그로 인하여, gold 이송 후 남는 용량에 silver를 옮길 수 있는 경우를 고려하지 못함
