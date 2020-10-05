# -*- coding: utf-8 -*-
"""
Created on Mon Oct  5 16:45:11 2020

@author: Rishi2
"""


def mergesort(arr):
    if len(arr) == 1:
        return arr
    fh = mergesort(arr[:len(arr)//2])
    sh = mergesort(arr[len(arr)//2:])
    
    result = []
    i = 0
    j = 0
    while i < len(fh) and j < len(sh):
        if fh[i] > sh[j]:
            result.append(sh[j])
            j += 1
        elif fh[i] < sh[j]:
            result.append(fh[i])
            i += 1
        else:
            result += [fh[i]]*2
            i += 1
            j += 1
    if i < len(fh):
        result += fh[i:]
    elif j < len(sh):
        result += sh[j:]
    return result

if __name__ == '__main__':
    f = open('random_nums.txt')
    m = f.read().split(' ')
    arr = []
    for i in m:
        try:
            arr.append(int(i))
        except:
            pass
    print(mergesort(arr))