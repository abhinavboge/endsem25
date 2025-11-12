
def fibonacci_recursive(n):
    if n <= 0:
        return []
    elif n == 1:
        return [0]
    elif n == 2:
        return [0, 1]
    
    fib_sequence = fibonacci_recursive(n - 1)
    fib_sequence.append(fib_sequence[-1] + fib_sequence[-2])
    return fib_sequence

n = int(input("Enter number of terms: "))
print("Fibonacci sequence (Recursive):", fibonacci_recursive(n))
