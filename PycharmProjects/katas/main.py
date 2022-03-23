def max_sequence1(arr):
    sortArr = sorted(arr)
    if (len(sortArr) == 0 or sortArr[-1] < 0):
        return 0
    maxSum = sum(arr)
    for i in range(len(arr)):
        for j in range(len(arr)):
            if sum(arr[i:j]) > maxSum:
                maxSum = sum(arr[i:j])
    return maxSum

def max_sequence2(arr):
    curr_max = arr[0]
    max_end = 0

    for i in range(len(arr)):
        max_end = max_end + arr[i]
        if max_end < 0:
            max_end = 0
        elif (curr_max < max_end):
            curr_max = max_end
    return curr_max



def main():
    arr = [8, -18, 24, 11, -9, 15, -3, -23, -21, 6, -7, 30, -11, -30, -17, -3, 25, -17, -15, -24, -22, -15, 5, -29, 2, -4, 21, 23, 1, -14, 11, -22, -18, -29, 27, 15, -24, 6, -13, -8, 12, -3, -15, 17, -12, 21, 10, 25, 25, 17]
    print(max_sequence1(arr))
    print(max_sequence2(arr))

if __name__ == "__main__":
    main()