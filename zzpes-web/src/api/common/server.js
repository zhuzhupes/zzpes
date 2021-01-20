import {fetchList} from '../commonUtils'

export function fetchServerList() {
  return fetchList('/jx3ServerInfo')
}
