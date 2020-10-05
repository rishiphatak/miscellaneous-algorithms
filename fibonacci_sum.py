# -*- coding: utf-8 -*-
"""
Created on Mon Oct  5 16:32:16 2020

@author: Rishi2
"""

def fib(x):
    a = 1
    b = 1
    i = 0
    while i < x:
        a, b = b, a+b
        i += 1
    return a


def get_fib_sequence(n):
    """
    Returns the unique Fibonacci numbers 
    that add up to this positive integer 

    Parameters
    ----------
    n : a positive integer

    Returns
    -------
    a list of Fibonacci numbers

    """
    if n <= 1:
        return [1]
    
    i = 1
    while fib(i) <= n:
        i += 1
    
    if fib(i-1) == n:
        return [n]
    
    return [fib(i-1)] + get_fib_sequence(n-fib(i-1))
        
if __name__ == '__main__':
    print(get_fib_sequence(32951280098))
        