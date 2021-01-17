import {fetchList} from '../commonUtils'

export function fetchOcptList() {
  return fetchList('/jx3OcptInfo')
}
