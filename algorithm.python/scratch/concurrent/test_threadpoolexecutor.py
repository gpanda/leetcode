from collections import OrderedDict
from concurrent.futures import ThreadPoolExecutor
import itertools
import pprint
import sys
import threading
import time

COUNT = 0
global_lock = threading.Lock()

def job(item):
    global COUNT
    global_lock.acquire()
    COUNT += 1
    local_count = COUNT
    global_lock.release()
    print("sleep:{}".format(local_count))
    time.sleep(local_count)
    ret  = str(local_count)
    ret += ":" + threading.currentThread().name
    ret += ":" + str(type(item))
    ret += ":" + str(item)
    return ret

def test_1():
    d1 = OrderedDict()
    d1['c'] = 3
    d1['b'] = 2
    d1['a'] = 1
    d2 = OrderedDict()
    d2['C'] = -3
    d2['B'] = -2
    d2['A'] = -1
    print("\nStart to map")
    with ThreadPoolExecutor(max_workers=4) as executor:
        results = executor.map(job, itertools.chain(d1.items(), d2.items()))
        for r in results:
            print(r)
