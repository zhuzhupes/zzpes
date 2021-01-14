import logging
import threading


def process_io_info(rec_conn):
    '''
        输入输出总览操作管道
    '''
    while True:
        type, key, val = rec_conn.recv()
        if(type == 'end'):
            break
        elif(type == io_info_error_type):
            old_error_lists = {}
            with open(error_file_path, 'r') as f:
                old_error_lists = json.load(f)
            old_error_lists[key] = get_date_time()
            with open(error_file_path, 'w') as f:
                f.write(json.dumps(old_error_lists))

