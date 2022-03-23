def maxsubarray(array):
    answer = 0
    for i in range(len(x)):
        for j in range(len(x)):
            if sum(x[i:j + 1]) > answer:
                answer = sum(x[i:j + 1])
    return answer

if __name__ == '__main__':
    x = [1,2,3, -123, 4,2,1]
    print(maxsubarray(x))